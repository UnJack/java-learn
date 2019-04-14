/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.agent.trace;

/**
 * 
 * 
 * <h3>Pinpoint Internal (0 ~ 999)</h3>
 * 
 * <table>
 * <tr><td>-1</td><td>UNDEFINED</td></tr>
 * <tr><td>1</td><td>UNKNOWN</td></tr>
 * <tr><td>2</td><td>USER</td></tr>
 * <tr><td>3</td><td>UNKNOWN_GROUP</td></tr>
 * <tr><td>5</td><td>TEST</td></tr>
 * <tr><td>7</td><td>COLLECTOR</td></tr>
 * <tr><td>100</td><td>ASYNC</td></tr>
 * </table>
 *
 * 
 * <h3>Server (1000 ~ 1899)</h3>
 * 
 * <table>
 * <tr><td>1000</td><td>STAND_ALONE</td></tr>
 * <tr><td>1005</td><td>TEST_STAND_ALONE</td></tr>
 * <tr><td>1010</td><td>TOMCAT</td></tr>
 * <tr><td>1011</td><td>TOMCAT_METHOD</td></tr>
 * <tr><td>1020</td><td><i>RESERVED</i></td></tr>
 * <tr><td>1021</td><td><i>RESERVED</i></td></tr>
 * <tr><td>1030</td><td>JETTY</td></tr>
 * <tr><td>1031</td><td>JETTY_METHOD</td></tr>
 * <tr><td>1100</td><td>THRIFT_SERVER</td></tr>
 * <tr><td>1101</td><td>THRIFT_SERVER_INTERNAL</td></tr>
 * <tr><td>1110</td><td>DUBBO_PROVIDER</td></tr>
 * </table>
 * 
 * <h3>Server Sandbox (1900 ~ 1999)</h3>
 * 
 * 
 * <h3>Database (2000 ~ 2899)</h3>
 * <table>
 * <tr><td>2050</td><td>UNKNOWN_DB</td></tr>
 * <tr><td>2051</td><td>UNKNOWN_DB_EXECUTE_QUERY</td></tr>
 * <tr><td>2100</td><td>MYSQL</td></tr>
 * <tr><td>2101</td><td>MYSQL_EXECUTE_QUERY</td></tr>
 * <tr><td>2150</td><td>MARIADB</td></tr>
 * <tr><td>2151</td><td>MARIADB_EXECUTE_QUERY</td></tr>
 * <tr><td>2200</td><td>MSSQL</td></tr>
 * <tr><td>2201</td><td>MSSQL_EXECUTE_QUERY</td></tr>
 * <tr><td>2300</td><td>ORACLE</td></tr>
 * <tr><td>2301</td><td>ORACLE_EXECUTE_QUERY</td></tr>
 * <tr><td>2400</td><td>CUBRID</td></tr>
 * <tr><td>2401</td><td>CUBRID_EXECUTE_QUERY</td></tr>
 * <tr><td>2410</td><td>NBASET</td></tr>
 * <tr><td>2411</td><td>NBASET_EXECUTE_QUERY</td></tr>
 * <tr><td>2412</td><td>NBASET_INTERNAL</td></tr>
 * <tr><td>2500</td><td>POSTGRESQL</td></tr>
 * <tr><td>2501</td><td>POSTGRESQL_EXECUTE_QUERY</td></tr>
 * <tr><td>2600</td><td>CASSANDRA</td></tr>
 * <tr><td>2601</td><td>CASSANDRA_EXECUTE_QUERY</td></tr>
 * </table>
 *
 * <h3>Database Sandbox (2900 ~ 2999)</h3>
 *
 *
 * <h3>RESERVED (3000 ~ 4999)</h3>
 *
 *
 * <h3>Library (5000 ~ 7499)</h3>
 * <table>
 * <tr><td>5000</td><td>INTERNAL_METHOD</td></tr>
 * <tr><td>5010</td><td>GSON</td></tr>
 * <tr><td>5011</td><td>JACKSON</td></tr>
 * <tr><td>5012</td><td>JSON-LIB</td></tr>
 * <tr><td>5050</td><td>SPRING</td></tr>
 * <tr><td>5051</td><td>SPRING_MVC</td></tr>
 * <tr><td>5061</td><td><i>RESERVED</i></td></tr>
 * <tr><td>5071</td><td>SPRING_BEAN</td></tr>
 * <tr><td>5500</td><td>IBATIS</td></tr>
 * <tr><td>5501</td><td>IBATIS-SPRING</td></tr>
 * <tr><td>5510</td><td>MYBATIS</td></tr>
 * <tr><td>6050</td><td>DBCP</td></tr>
 * <tr><td>7010</td><td>USER_INCLUDE</td></tr>
 * </table>
 *
 * <h3>Library Sandbox (7500 ~ 7999)</h3>
 *
 * <h3>Cache Library (8000 ~ 8899) Fast Histogram</h3>
 * <table>
 * <tr><td>8050</td><td>MEMCACHED</td></tr>
 * <tr><td>8051</td><td>MEMCACHED_FUTURE_GET</td></tr>
 * <tr><td>8100</td><td>ARCUS</td></tr>
 * <tr><td>8101</td><td>ARCUS_FUTURE_GET</td></tr>
 * <tr><td>8102</td><td>ARCUS_EHCACHE_FUTURE_GET</td></tr>
 * <tr><td>8103</td><td>ARCUS_INTERNAL</td></tr>
 * <tr><td>8200</td><td>REDIS</td></tr>
 * <tr><td>8250</td><td><i>RESERVED</i></td></tr>
 * <tr><td>8251</td><td><i>RESERVED</i></td></tr>
 * </table>
 * <h3>Cache Library Sandbox (8900 ~ 8999) Histogram type: Fast </h3>
 * 
 * 
 * <h3>RPC (9000 ~ 9899)</h3>
 * <table>
 * <tr><td>9050</td><td>HTTP_CLIENT_3</td></tr>
 * <tr><td>9051</td><td>HTTP_CLIENT_3_INTERNAL</td></tr>
 * <tr><td>9052</td><td>HTTP_CLIENT_4</td></tr>
 * <tr><td>9053</td><td>HTTP_CLIENT_4_INTERNAL</td></tr>
 * <tr><td>9054</td><td>GOOGLE_HTTP_CLIENT_INTERNAL</td></tr>
 * <tr><td>9055</td><td>JDK_HTTPURLCONNECTOR</td></tr>
 * <tr><td>9056</td><td>ASYNC_HTTP_CLIENT</td></tr>
 * <tr><td>9057</td><td>ASYNC_HTTP_CLIENT_INTERNAL</td></tr>
 * <tr><td>9058</td><td>OK_HTTP_CLIENT</td></tr>
 * <tr><td>9059</td><td>OK_HTTP_CLIENT_INTERNAL</td></tr>
 * <tr><td>9060</td><td><i>RESERVED</i></td></tr>
 * <tr><td>9070</td><td><i>RESERVED</i></td></tr>
 * <tr><td>9100</td><td>THRIFT_CLIENT</td></tr>
 * <tr><td>9101</td><td>THRIFT_CLIENT_INTERNAL</td></tr>
 * <tr><td>9110</td><td>DUBBO_CONSUMER</td></tr>
 * </table>
 *
 * <h3>RPC Sandbox (9900 ~ 9999)</h3>
 *
 * 
 * <tr><td></td><td></td></tr>
 * 
 * @author emeroad
 * @author netspider
 * @author Jongho Moon
 */
public interface ServiceType {
}