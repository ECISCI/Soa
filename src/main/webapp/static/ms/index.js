NProgress.start();
window.onload = function () {
    NProgress.done();
}
var element;
layui.use(['element', 'layer'], function () {
    element = layui.element;
    var layer = layui.layer;
    init();
    //菜单初始化
    function init(){
    	$("#username").text(admUser.username);
    	let pdata = '{"pageNumber":1,"pageSize":200}';
    	post("admmenu/getList",pdata,createmenu);
    	for ( let ip in nodeipports) {
			let path = 'http://'+nodeipports[ip]+noderoot+'apiregister/connectivityTestAll';
			postapigw(path);
		}
    }
    
    //构建菜单
    function createmenu(data) {
		if (data=="undifined") {
			layer.msg('获取菜单数据失败 ！');
		} else {
			if (data.errorCode=="10000") {
				let realdata=data.realResult.realResult.list;
				let level1menu = {};
				for (let x in realdata) {
					let item = realdata[x];
					if (item.parent==0) {
						item.children = new Array();
						level1menu[item.id]=item;
					}else {
						level1menu[item.parent].children.push(item);
					}
				}
				
				let k=0;
				for ( var key in level1menu) {
					let menuitem = level1menu[key];
					let liobj = createlevel1menu(menuitem,k++);
					$("#navtree").append(liobj);
				}
				layui.use('element', function() {
                    var element = layui.element;
                    element.init();
                });
			} else {
				layer.msg(data.errorMsg);
			}
		}
	}
    
    //构建一级菜单
	function createlevel1menu(obj,k) {
  		let liobj = $("<li></li>");
  		liobj.addClass("layui-nav-item");
  		if (k==0) {
  			liobj.addClass("layui-nav-itemed");
  		}
  		
  		let aobj = $("<a></a>");
  		aobj.text(obj.name);
  		aobj.attr({href:"javascript:;"});
  		
  		let iobj = $("<i></i>");
  		iobj.addClass("layui-icon");
  		iobj.html(obj.icon);
  		
  		aobj.prepend(iobj);
  		
  		liobj.append(aobj);
  		if (obj.hasOwnProperty('children')) {
  		  let dlobj = $("<dl></dl>");
  		  dlobj.addClass("layui-nav-child");
  		  let children = obj.children;
  		  for (let i = 0; i < children.length; i++) {
			var child = children[i];
			let ddobj = createlevel2menu(child,k+1,i+1);
			dlobj.append(ddobj);
  		  }
  		  liobj.append(dlobj);
  		}
  		return liobj;
  	}
	//构建二级菜单
  	function createlevel2menu(obj,m,n) {
  		let ddobj = $("<dd></dd>");
  		
  		let aobj = $("<a></a>");
  		aobj.text(obj.name);
  		aobj.attr({href:"javascript:;",path:obj.url,'tab-id':m+"-"+n});
  		
  		let iobj = $("<i></i>");
  		iobj.addClass("iconfont");
  		iobj.addClass(obj.icon);
  		
  		aobj.prepend(iobj);
  		ddobj.append(aobj);
  		return ddobj;
  	}
    /**
     * 左边菜单显示/隐藏功能
     * @type {boolean}
     */
    $(".menu-switch").click(function () {
        if ($(".layui-layout-admin .layui-side").css("left") == '0px') {
            $(".layui-layout-admin .layui-side").animate({left: "-200px"});
            $(".layui-layout-admin .content-body").animate({left: "0px"});
            $(".layui-layout-admin .layui-footer").animate({left: "0px"});
        } else {
            $(".layui-layout-admin .layui-side").animate({left: "0px"});
            $(".layui-layout-admin .content-body").animate({left: "200px"});
            $(".layui-layout-admin .layui-footer").animate({left: "200px"});
        }
    });

    /**
     * 点击左边菜单在右边添加选项卡
     */
    $("#navtree").on("click","dd",function () {
        // 纯文字
        // var title = $(this).text();
        // 图标+文字
        var title = $(this).find("a").html();
        var path = $(this).children('a').attr('path');
        var tabId = $(this).children('a').attr('tab-id');
        // 去重复选项卡
        for (var i = 0; i < $('.ok-frame').length; i++) {
            if ($('.ok-frame').eq(i).attr('tab-id') == tabId) {
                element.tabChange("ok-tab", tabId);
                event.stopPropagation();
                return;
            }
        }
        // 添加选项卡
        element.tabAdd("ok-tab", {
            title: title,
            content: "<iframe src='" + path + "' tab-id='" + tabId + "' class='ok-frame' frameborder='0' scrolling='yes' width='100%' height='100%'></iframe>",
            id: tabId
        });
        // 切换选项卡
        element.tabChange("ok-tab", tabId);
    });

    /**
     * 退出操作
     */
    $("#logout").click(function () {
        layer.confirm("确定要退出吗？", {skin: 'layui-layer-lan', icon: 3, title: '提示', anim: 6}, function () {
    	    $.ajax({
    	        url:baseurl+"logout",
    	        type:"post",
    	        contentType:"application/json;charset=utf-8",
    	        dataType:"json",
    	        success:function(data){
    	        	if (data.errorCode=='10000') {
    	        		$.session.remove('currentloginuser');
    	        		layer.msg('成功退出');
    	        		window.location=baseurl;
    				}else {
    					layer.msg('退出失败 '+data.errorMsg);
    				}
    	        },
    	        error:function(data){
    	        	layer.msg('退出失败 '+data.errorMsg);
    	        }
    	    });
        });
    });

    /**
     * 锁定账户
     */
    $("#lock").click(function () {
        layer.confirm("确定要锁定账户吗？", {skin: 'layui-layer-lan', icon: 4, title: '提示', anim: 1}, function (index) {
            layer.close(index);
            $(".yy").show();
            layer.prompt({
                btn: ['确定'],
                title: '输入密码解锁(123456)',
                closeBtn: 0,
                formType: 1
            }, function (value, index, elem) {
                if (value == "123456") {
                    layer.close(index);
                    $(".yy").hide();
                } else {
                    layer.msg('密码错误', {anim: 6});
                }
            });
        });
    });
});

function addtab(jqobj) {
    // 纯文字
    // var title = $(this).text();
    // 图标+文字
    var title = jqobj.text();
    var path = jqobj.attr('path');
    var tabId = jqobj.attr('tab-id');
    // 去重复选项卡
    for (var i = 0; i < $('.ok-frame').length; i++) {
        if ($('.ok-frame').eq(i).attr('tab-id') == tabId) {
        	element.tabChange("ok-tab", tabId);
            event.stopPropagation();
            return;
        }
    }
    // 添加选项卡
    element.tabAdd("ok-tab", {
        title: title,
        content: "<iframe src='" + path + "' tab-id='" + tabId + "' class='ok-frame' frameborder='0' scrolling='yes' width='100%' height='100%'></iframe>",
        id: tabId
    });
    // 切换选项卡
    element.tabChange("ok-tab", tabId);
};