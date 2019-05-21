package com.deepinto.aibi.nignx;

/**
 * @author Ming
 */
public class nginxInstall {
    /**
     * @1.nginx简介
     */
    /*
     * Nginx是一款高性能http服务器/反向代理服务器,及电子邮件（IMAP/POP3）代理服务器
     *
     * 由俄罗斯的程序设计师IgorSysoev所开发,官方测试nginx能够支撑5万并发链接
     *
     * 并且cpu,内存等资源消耗非常低,运行非常稳定
     */

    /**
     * @2.nginx的应用场景
     */
    /*
     *  1.http服务器, Nginx是一个Http服务可以独立提供http服务, 可以做网页静态服务器
     *
     *  2.虚拟主机, 可以实现在一台服务器虚拟出多个网站, 例如个人网站使用的虚拟主机
     *
     *  3.反向代理 负载均衡, 当网站访问量达到一定程度后, 单台服务器不能满足用户的请求时
     *
     *  需要多台服务器集群,可以使用nginx做反向代理,并且多台服务器可以平均分担负载,
     *
     *  不会因为某台服务器负载高宕机而某台服务器闲置的情况
     */

    /**
     * @3.nginx安装
     *
     * @注意.nginx是C语言编写的linux版只提供源代码, 所以安装nginx需要编译
     *
     * @扩展.nginx不像redis一样可以直接执行makecmd, 需要预先执行configcmd
     */
    /* 1.将nginx压缩包上传到linux服务器 （最好不要上传到/usr/local,后面会做解释）（当然不是必要的其实在哪都行,但最好区分）
     *
     * 2 nginx编译需要安装gcc环境
     *
     * yum cmd yum install gcc-c++ <必须联网>
     *
     * 3.PCRE（第三方开发包）
     *
     * PCRE是一个perl库包括perl兼容的正则表达式库,nginx的http模块使用pcre来解析正则表达式
     *
     * yum cmd yum install -y pcre pcre-devel
     *
     * 4.zlib（第三方开发包）
     * zlib库提供了很多压缩和解压缩的方式,nginx使用zlib对http包的内容进行 gzip,
     *
     * yum cmd yum install -y zlib zlib-devel
     *
     * 5.openssl(第三方开发包)
     *
     * OpenSSL是一个强大的安全套接字层密码库,囊括主要的密码算法,常用的密钥和证书封装管理功能
     * 及SSL协议,并提供丰富的应用程序供测试或其他目的使用
     *
     * nginx不仅支持http协议还支持https（即在ssl协议上传输http）
     *
     * yum cmd yum install -y openssl openssl-devel
     *
     * 6. 在根目录下创建一个apps文件夹,将nginx压缩包上传到该文件夹下
     *
     * 6.1 解压缩
     *
     * cmd tar -zxvf nginx-1.8.0.tar.gz
     *
     * 6.2 进入解压缩后的nginx目录
     *
     * cmd cd nginx-1.8.0
     *
     * 6.3 编译nginx
     *
     * 执行config cmd config cmd在 配置文件.html文件中
     *
     * 6.4### ！！！需要注意
     * nginx_config.text cmd中有一条 prefix=/usr/local/nginx （这是指定nginx最终的安装目录,无需手动创建）
     *
     * 如果该目录下有nginx文件夹,请将该文件夹删除
     *
     * 6.5 执行config cmd之后会在nginx目录下出现makefile可编译文件,这样就可以执行make
     *
     * 7.编译
     *
     * cmd make
     *
     * 8.安装
     *
     * cmd make install
     *
     * */

    /**
     * @4.ningx目录说明
     */
    /*
     *  1.进入nginx安装目录
     *
     *          cmd cd /usr/local/nginx
     *
     *  2.conf目录 配置文件 <核心为nginx.config文件,之后的测试都需要在这个文件上做>
     *
     *  3.html根目录欢迎页
     *
     *  4.sbin 是一个可执行的nginx服务
     */

    /**
     * @5.启动nginx
     */
    /*
     *  1.进入nginx安装目录 , cmd cd /usr/local/nginx
     *
     *  2.进入sbin目录 cmd cd /sbin
     *
     *  3.启动nginx ./nginx
     *      nginx: [emerg] mkdir() "/var/temp/nginx/client" failed (2: No such file or directory)
     *
     *      出现如上描述证明启动失败,
     *
     *      需要创建目录
     *      mkdir  /var/temp/nginx -p 一定要加-p
     *
     *  4.再次启动nginx
     *
     *  4.1
     *      ./nginx 没有提示(在Linux中没有提示就是最好的)
     *
     *  4.2
     *      查看nginx是否启动成功,
     *
     *      cmd ps aux|grep nginx
     *      root      19485  0.0  0.0  23852   796 ?        Ss   22:51   0:00 nginx: master process ./nginx
     *      nobody    19486  0.0  0.0  24280  1388 ?        S    22:51   0:00 nginx: worker process
     *
     *      必须出现  master  worker 这才是证明 nginx启动成功,只有其中一个证明启动失败
     *
     *  5.外部访问,直接访问 192.168.25.129（虚拟机ip地址） nginx默认为80端口
     *
     *      浏览器出现 welcome to nginx证明成功
     *
     *      ！！！注意:外部浏览器访问的时候一定要先关闭防火墙 service iptables stop(systemctl stop firewalld.service)
     * */

    /**
     * @6.停止nginx服务
     */
    /*
     * 1.进入nginx安装目录
     *
     * 2.第一种关闭方法 sbin/nginx -s stop (注意一定要加上-s)
     *
     * 3.第二种关闭方法 sbin/nginx -s quit (一般说这种方式更好,具体哪好我也不清楚)
     */


    /**
     * @7.配置虚拟主机,通过监听端口区分不同的访问
     */
    /* 1.进入nginx的配置文件目录
     *
     *      进入nginx的安装目录 cmd cd /usr/local/nginx/conf
     *
     * 2.查看配置文件
     *
     *      cmd vim nginx.conf
     */

    /**
     * @8.编辑nginx.conf
     *
     */
    /*
     * 如果配置虚拟主机,需要对nginx.conf进行编辑,但编辑nginx.conf在linuxcmd行下是非常不方便的
     *
     * 这里推荐使用 EditPlus文本编辑器编辑nginx.conf
     *
     * 1.打开EditPlus(EditPlus随处可下载,随便下载一个最新版本的就可以了)
     *
     *
     * 2.点击File -->FTP-->FTP Settings
     *
     * 3.配置FTP
     *
     *      3.1Description 给你连接的linux系统FTP起个名字<这里取名为nginx>
     *
     *      3.2 server 连接到Linux的ip<即Linux的ip地址>
     *
     *      3.3 username 登录linux的用户名
     *
     *      3.4 password 登录linux的密码
     *
     *      3.5 点开Advanced Options Encryption选项选择 sftp port 填入22(也可以不输入,默认就是22)
     *
     *      点击OK结束Advanced Options
     *
     *      3.6 点击OK关闭当前FTP Setting页面 在左侧Directory,选择设置好的连接即可
     *
     * */

    /**
     * @9编辑 nginx.conf
     */

    /*
     *  1.打开EditPlus连接到服务器 进入/usr/local/nginx/conf
     *
     *  2.编辑nginx.conf
     *
     *  3.###注意 这里最主要的就是编辑server节点
     *
     *  4.server节点参数说明
     *
     *      4.1 listen nginx监听的端口
     *
     *      4.2 server_name
     *
     *      4.3 root
     *
     *      4.4 index
     */

    /**
     * @10.增加Server节点（通过端口区分不同的访问）
     */
    /*
     * ###注意:!!! nginx: [error] open() "/var/run/nginx/logs/nginx.pid" failed (2: No such file or directory)
     *
     * 1.如果reload的时候遇到上面的错误请不要吓的尿裤子
     *
     * 2.当你进入这个目录的时侯会发现目录中的文件夹都在, 但nginx.pid文件不在
     *
     * 3.为什么nginx.pid文件不在？因为这个文件只有的nginx启动的时候才会生成的临时文件,关闭nginx或者重启都会消失
     *
     * 解决办法：
     *
     * 1.进入 /usr/local/conf 编辑nginx.conf文件,找到pid项将注释去掉
     *
     * 2.启动nginx(注意要保证nginx是启动状态)
     *
     * EditPlus编辑server节点, 重新reload就不会报这种错误
     */

    /*  1.拷贝server节点
     *
     *  2.粘贴在当前目录下
     *
     *  3.修改listen 81
     *
     *  4.连接虚拟机 将/usr/local/nginx/html 复制一份到当前目录
     *
     *      cmd cp -r html/ html81
     *
     *  5.修改html81欢迎页里面的内容
     *
     *      5.1 进入html81目录
     *
     *      执行cmd vim index.html
     *
     *  5.2 随便改或者增加点内容让你知道这是81端口的页面即可
     *
     *  5.3 重新加载配置文件让你生效
     *
     *      cmd sbin/nginx -s reload
     *
     *  5.4测试
     *
     *      访问 http://192.168.25.129:81/ 会出现你编辑的html81下的index.html样式
     *
     *      访问成功！ 通过端口区分不同的虚拟主机
     */

    /**
     * @11.通过域名区分不同虚拟主机
     */
    /* 1.打开EditPlus编辑 nginx.conf 文件
     *
     * 2.首先将listen监听的端口号都改为 80
     *
     * 3.编辑server节点下的server_name
     *
     * 4.第一个server节点下的server_name更改为 www.nginx80.com
     *
     * 5.第二个server节点下的server_name更改为 www.nginx81.com
     *
     * 6.记得reload ./nginx -s reload重新加载配置文件
     *
     * 7.在windows中配置域名和IP的映射 C:\Windows\System32\drivers\etc\hosts
     *
     *      配置--> 192.168.25.129 www.nginx81.com 192.168.25.129 www.nginx80.com(将这两端映射关系拷贝进去即可)
     *
     * 9.外部访问 www.nginx81.com nginx  www.nginx80.com nginx
     *
     *  会根据不同域名的访问去调起nginx本地静态html页面
     */

}

