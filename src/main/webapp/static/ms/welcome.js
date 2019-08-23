    init();
	/**
     * 初始化函数
     */
	function init(){
		$("#cnname").text(admUser.name);
		setDate();
		getnuminfo();
	}
    

    /**
     * 获取当前时间
     */
    var nowDate1 = "";
    function setDate() {
        var date = new Date();
        var year = date.getFullYear();
        nowDate1 = year + "-" + addZero((date.getMonth() + 1)) + "-" + addZero(date.getDate()) + "  ";
        nowDate1 += addZero(date.getHours()) + ":" + addZero(date.getMinutes()) + ":" + addZero(date.getSeconds());
        document.getElementById("nowTime").innerHTML = nowDate1;
        setTimeout('setDate()', 1000);
    }

    /**
     * 年月日是分秒为10以下的数字则添加0字符串
     * @param time
     * @returns {number | *}
     */
    function addZero(time) {
        var i = parseInt(time);
        if (i / 10 < 1) {
            i = "0" + i;
        }
        return i;
    }

    /**
     * 初始化星期几
     * @type {string}
     */
    var weekday = "星期" + "日一二三四五六".charAt(new Date().getDay());
    document.getElementById("weekday").innerHTML = weekday;

    layui.use(['util', 'layer','table'],function () {
        var util = layui.util;
        util.fixbar({});
        
        var layer = layui.layer;
        
        var table = layui.table;
        let pdata = '{"pageNumber":1,"pageSize":20}';
    	post("admsysinfo/getList",pdata,getsysinfo);
    	function getsysinfo(data) {
        	if (data=="undifined") {
    			layer.msg('获取数据失败 ！');
    		} else {
    			if (data.errorCode=="10000") {
    				let list=data.realResult.realResult.list;
    		        table.render({
    		            elem: '#nodeinfo'
    		            ,data: list
    		            ,page: true //开启分页
    		            ,cols: [[ //表头
    		              {field: 'sysName', title: '节点名称', width:110, sort: false}
    		              ,{field: 'ip', title: '节点IP', width:120}
    		              ,{field: 'osv', title: '操作系统', width:120, sort: false}
    		              ,{field: 'jdkv', title: 'jdk版本', width:110} 
    		              ,{field: 'dbversion', title: '数据库', width: 110}
    		              ,{field: 'totalMemory', title: '系统内存', width: 80, sort: false}
    		              ,{field: 'availableMemory', title: '可用内存', width: 80, sort: false}
    		              ,{field: 'totalspace', title: '硬盘空间', width: 80, sort: false}
    		              ,{field: 'availspace', title: '可用空间', width: 80, sort: false}
    		              ,{field: 'description', title: '节点描述'}
    		              ,{field: 'status', title: '状态', width: 80, sort: false}
    		            ]]
    		          });
    			}
    		}
		}
    });
    //获取系统统计信息
    function getnuminfo() {
    	let pdata;
    	post("admsysinfo/getNum",pdata,getnumsucc);
	}
    
    function getnumsucc(data) {
    	if (data=="undifined") {
			layer.msg('获取数据失败 ！');
		} else {
			if (data.errorCode=="10000") {
				let realdata=data.realResult.realResult;
				$("#usernum").text(realdata.usernum);
				$("#exceptaccessnum").text(realdata.exceptaccessnum);
				$("#accessedapinum").text(realdata.accessedapinum);
				$("#nodenum").text(realdata.nodenum);
				$("#apinum").text(realdata.apinum);
				$("#accessnum").text(realdata.accessnum);
			}
		}
	}
    
    $(".md2-sub1").click(function() {
    	let path = $(this).attr("path");
    	if (typeof(path)!="undefined") {
    		let ajqobj = $("#navtree",window.parent.document).find("a[path='"+path+"']");
    		parent.addtab(ajqobj);
		}
	});