<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>HD首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	

 <link rel="stylesheet" href="css/indexcss.css" type="text/css"></link>
 </head>

<body>
	<center>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td>
			<jsp:include page="intop.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td>
					<div class="xd1">
						<div class="d1">
				<div id="player">
		 <ul class="Limg">
		 <li><img src="images/24-110G0141102.jpg"></img></li>
		 <li><img src="images/24-110G0141103.jpg"></img></li>
		 <li><img src="images/24-110G0141106.jpg"></img></li>
		 <li><img src="images/24-110G0141108.jpg"></img></li>
		 </ul>
		<cite class="Nubbt"><span class="on">1</span><span >2</span><span >3</span><span >4</span></cite> 
		</div>
		<script language=javascript type="text/javascript">
		//*焦点切换
		(function(){
		    if(!Function.prototype.bind){
		        Function.prototype.bind = function(obj){
		            var owner = this,args = Array.prototype.slice.call(arguments),callobj = Array.prototype.shift.call(args);
		            return function(e){e=e||top.window.event||window.event;owner.apply(callobj,args.concat([e]));};
		        };
		    }
		})();
		var player = function(id){
		    this.ctn = document.getElementById(id);
		    this.adLis = null;
		    this.btns = null;
		    this.animStep = 0.2;//动画速度0.1～0.9
		    this.switchSpeed = 3;//自动播放间隔(s)
		    this.defOpacity = 1;
		    this.tmpOpacity = 1;
		    this.crtIndex = 0;
		    this.crtLi = null;
		    this.adLength = 0;
		    this.timerAnim = null;
		    this.timerSwitch = null;
		    this.init();
		};
		player.prototype = {
		    fnAnim:function(toIndex){
		        if(this.timerAnim){window.clearTimeout(this.timerAnim);}
		        if(this.tmpOpacity <= 0){
		            this.crtLi.style.opacity = this.tmpOpacity = this.defOpacity;
		            this.crtLi.style.filter = 'Alpha(Opacity=' + this.defOpacity*100 + ')';
		            this.crtLi.style.zIndex = 0;
		            this.crtIndex = toIndex;
		            return;
		        }
		        this.crtLi.style.opacity = this.tmpOpacity = this.tmpOpacity - this.animStep;
		        this.crtLi.style.filter = 'Alpha(Opacity=' + this.tmpOpacity*100 + ')';
		        this.timerAnim = window.setTimeout(this.fnAnim.bind(this,toIndex),50);
		    },
		    fnNextIndex:function(){
		        return (this.crtIndex >= this.adLength-1)?0:this.crtIndex+1;
		    },
		    fnSwitch:function(toIndex){
		        if(this.crtIndex==toIndex){return;}
		        this.crtLi = this.adLis[this.crtIndex];
		        for(var i=0;i<this.adLength;i++){
		            this.adLis[i].style.zIndex = 0;
		        }
		        this.crtLi.style.zIndex = 2;
		        this.adLis[toIndex].style.zIndex = 1;
		        for(var i=0;i<this.adLength;i++){
		            this.btns[i].className = '';
		        }
		        this.btns[toIndex].className = 'on'
		        this.fnAnim(toIndex);
		    },
		    fnAutoPlay:function(){
		        this.fnSwitch(this.fnNextIndex());
		    },
		    fnPlay:function(){
		        this.timerSwitch = window.setInterval(this.fnAutoPlay.bind(this),this.switchSpeed*1000);
		    },
		    fnStopPlay:function(){
		        window.clearTimeout(this.timerSwitch);
		    },
		    init:function(){
		        this.adLis = this.ctn.getElementsByTagName('li');
		        this.btns = this.ctn.getElementsByTagName('cite')[0].getElementsByTagName('span');
		        this.adLength = this.adLis.length;
		        for(var i=0,l=this.btns.length;i<l;i++){
		            with({i:i}){
		                this.btns[i].index = i;
		                this.btns[i].onclick = this.fnSwitch.bind(this,i);
		                this.btns[i].onclick = this.fnSwitch.bind(this,i);
		            }
		        }
		        this.adLis[this.crtIndex].style.zIndex = 2;
		        this.fnPlay();
		        this.ctn.onmouseover = this.fnStopPlay.bind(this);
		        this.ctn.onmouseout = this.fnPlay.bind(this);
		    }
		};
		var player1 = new player('player');
		</script>
			</div>
					</div>
			<div class="xd2">
				<div class="xd3">
					热线电话：11111111
				</div>
				<div class="xd8">
					<form action="servlet/Sguanli" method="post">
						<table class="tb1" cellpadding="0" cellspacing="0" >
							<tr>
								<td colspan="2">用户登录</td>
							</tr>
						</table>
						<table class="tb2" cellpadding="0" cellspacing="0" border="0">
							<tr height="40" >
								<td ><center>用户名：</center></td>
								<td><input type="text" maxlength="8" height="20" name="username" /></td>
							</tr>
							<tr height="40" >
								<td><center>密码：</center></td>
								<td><input type="password" maxlength="30" height="20" name="userpwd" /></td>
							</tr>
							<tr height="30" >
								<td colspan="2">
									<center>
										<input type="radio" value="管理员" name="quanxian"/>管理员
										<input type="radio" value="司机" name="quanxian"/>司机
									</center>
								</td>
							</tr>
							<tr height="40">
								<td align="right"><input type="submit" value="登 陆"/></td>
								<td align="center"><input type="reset" value="重 置"/></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="xd4">
				公告栏
				</div>
				<div class="xd5">
					<br/>
					欢迎您来到HD!<br/>
					本站点正在建设完善中，由此给各位带来的不便，请谅解！
					
				</div>
				<div class="xd6">
				联系我们
				</div>
				<div class="xd7">
						<p>
						电话：00000000<br/>
						传真：22222222<br/>
						Email:lll@sina.com
						</p>	
				</div>
			</div>
				</td>
	</tr>
	<tr>
		<td>
		<jsp:include page="bottom.jsp"></jsp:include>
		</td>
	</tr>
	</table>
	</center>
	
  </body>
</html>
