package rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: jimjian
 * Date: 16-6-16 下午3:13
 */
public class DubboRpc {

    public static void export(final Object service, int port) throws IOException {
        if (service == null)
            throw new IllegalArgumentException("service instance == null");
        if (port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);
        System.out.println("Export service " + service.getClass().getName() + " on port " + port);
        final ServerSocket socketServer = new ServerSocket(port);
        while (true) {
            final Socket socket = socketServer.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ObjectInputStream objectInputStream = null;
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        objectInputStream = new ObjectInputStream(socket.getInputStream());
                        //方法名
                        String methodName = objectInputStream.readUTF();
                        Class<?>[] parameterTypes = (Class<?>[]) objectInputStream.readObject();
                        Object[] arguments = (Object[]) objectInputStream.readObject();

                        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                        Object object = method.invoke(service, arguments);
                        objectOutputStream.writeObject(object);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            objectOutputStream.close();
                            objectInputStream.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    public static <T> T refer(final Class<T> tClass, final String ip, final int port) {
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), new Class[]{tClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(ip, port);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(method.getName());
                objectOutputStream.writeObject(method.getParameterTypes());
                objectOutputStream.writeObject(args);

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Object object = objectInputStream.readObject();
                if (object instanceof Throwable) {
                    throw new Exception("输出异常~~~");
                }
                return object;
            }
        });
    }
}
