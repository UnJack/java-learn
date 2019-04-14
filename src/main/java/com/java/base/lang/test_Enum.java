package com.java.base.lang;

/**
 * Created by jian.jie on 2016/9/21.
 */
public class test_Enum {
    public static void main(String[] args) {
        System.out.println(Check.getValue("error1").getCode());
        System.out.println(Check.getValue("error2").getCode());
    }

    public enum Check {
        ERROR1("0000", "error1") {
            @Override
            protected Check createCheck() {
                return null;
            }
        },
        ERROR2("1111", "error2") {
            @Override
            protected Check createCheck() {
                return null;
            }
        };
        private String code;
        private String name;

        Check(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static Check getValue(String value) {
            for (Check category : Check.values()) {
                if (category.getName().equalsIgnoreCase(value)) {
                    return category;
                }
            }
            throw new IllegalArgumentException("Unknown CheckerCategory : " + value);
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        protected abstract Check createCheck();
    }

    public enum StatusType {
        error("000", "error"),
        success("001", "success");
        private String code;
        private String message;

        StatusType(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
