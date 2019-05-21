package com.deepinto.aibi.nignx;

/**
 * @author Ming
 * @描述 Nginx的反向代理 负载均衡
 */
public class nginxProxy {
    /**
     *  @1 配置tomcat
     */

    /*@1 将tomcat压缩包上传到linux服务器(/usr/local/nginx 目录下)
     *
     *@2 解压缩tomcat压缩包 tar -zxvf apache-tomcat-7.0.68
     *
     *@3 将tomcat 复制两份
     *
     *命令
     *
     * cp apache-tomcat-7.0.68/ tomcat-sina -r
     *
     * cp apache-tomcat-7.0.68/ tomcat-sohu -r
     *
     *@4 修改tomcat端口号（怎么改不做解释,这里和windows更改tomcat端口号一样）
     *
     *命令 vim tomcat-sina/conf/server.xml
     *
     * @5 区分不同端口访问不同的tomcat
     *
     * vim tomcat-sina/webapps/ROOT/index.jsp
     *
     * 搜索H1   <h1>${pageContext.servletContext.serverInfo}-sina</h1>
     *
     * 在版本号后面添加-sina以示区分
     *
     * sohu同理
     *
     * @6 更改完成后 刷新访问即可 示例完成
     */
    /**
     * @2 nginx增加server节点
     *
     */

    /*@1 将nginx.conf文件的server节点复制两份
     *
     *@2 更改server_name节点
     *
     * 2.1 www.sina.com
     *
     * 2.2 www.sohu.com
     *
     *@3 更改location节点下的root
     *
     * 3.1 见root更改为proxy_pass
     *
     * 3.2 proxy_pass节点的值更改为 http://sina
     *
     *@4 在server外层增加upstream sina节点
     *
     * 内部值 增加server节点
     *
     * {server 192.168.25.129:8080} // tomcat-sina的访问地址
     * */

}

