package com.deepinto.aibi.solr;

/***
 * @描述 Solr服务搭建Linux版
 *
 * * @安装包 zzlinuxinstallpackage目录下solr-4.10.3.tgz.tgz
 */
public class Solr {

    /**
     * @1. Solr简介
     */
    /*
     * @1 Solr是Java开发的
     *
     * @2 需要在linux上安装JDK
     *
     * @3 需要安装tomcat
     *
     * @4 当然Solr也可以安装在windows下, 但不推荐这么做
     *
     * */

    /**
     * @2. linux上安装并启动solr
     */
    /*
     * @1 将Solr压缩包上传到linux根目录apps文件夹下（如果没有apps文件夹就创建一个）
     *
     * 解压缩 命令 tar -zxvf solr-4.10.3.tgz.tgz
     *
     * @2 将solr-4.10.3.war复制到tomcat webapps目录下
     *
     * 2.1 进入solr的dist文件目录下
     *
     * 命令 cd solr-4.10.3/dist
     *
     * 2.2复制
     *
     * 命令 cp solr-4.10.3.war /usr/local/apache-tomcat-7.0.47/webapps/solr.war
     *
     * 2.3 启动tomcat solr.war会自动解压缩,
     *
     * 2.4 删除solr.war 进入tomcat webapps目录下执行命令 rm -rf solr.war
     *
     * 注意,删除war包之前一定要关闭tomcat,否则会联通war包解压缩后生成的文件一并删除
     *
     * @3 solr需要几个依赖包,依赖包在</apps/solr-4.10.3/example/lib/ext>目录下
     *
     * 进入此目录执行拷贝命令
     *
     * cp * /usr/local/tomcat-solr/webapps/solr/WEB-INF/lib/
     *
     * @4 需要一个solrhome
     *
     * 4.1 进入 /usr/local目录下创建一个solr文件夹<mkdir solr>
     *
     * 4.2 进入 /apps/solr-4.10.3/example/目录下
     *
     * 执行拷贝命令 cp solr -r /usr/local/solr/solrhome (给拷贝的solr重命名为solrhome)
     *
     * @5 更改配置让solr服务指导solrhome在哪里。
     *
     * 命令 vim /usr/local/tomcat-solr/webapps/solr/WEB-INF/web.xml
     *
     * 5.1 找到 <env-entry>节点将注释去掉
     *
     * 5.2 将env-entry-value子节点的值更改为真实的路径 即/usr/local/solr/solrhome
     *
     * 5.3 启动solr 进入tomcat目录下,进入bin目录下 ./startup.sh
     *
     * 5.4 判断solr是否启动成功,在本机访问http://192.168.25.129:8080/solr
     *
     * 这样就可以进入solr后台了,（#注意一定要关闭防火墙 service iptables stop）
     */

    /**
     * @3.solr 业务域的配置
     */
}
