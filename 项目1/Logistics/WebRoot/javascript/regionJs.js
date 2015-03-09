/* 
      作者：黄翠
      完成日期：2011年7月20日
*/
/*定义test（）方法验证目的地管理增加区域时区域名称不为空*/
function test()
{
	var q1=document.getElementById("q1").value;
	if(q1=="")
		{
		alert("区域名称不能为空！");	
		return false;
		}	
}
/*定义test2（）方法验证目的地管理编辑货场区域时货场面积输入为正整数*/
function test2()
{
	var tmp=/^[0-9]*$/;
	var strmsg=document.getElementById('b4').value;
	var intArea = parseInt(strmsg);
	if(!tmp.test(strmsg)||strmsg<0)
	{
		alert("货场面积请输入正整数！");
		return false;
	}
}
/*定义test3（）方法验证目的地管理新增货场区域时货场面积输入为正整数*/
function test3()
{
	var tmp=/^[0-9]*$/;
	var strmsg=document.getElementById('j4').value;
	var intArea = parseInt(strmsg);
	
	var q1=document.getElementById("j1").value;
	if(q1=="")
		{
		alert("货场名称不能为空！");	
		return false;
	}
	var q3=document.getElementById("j3").value;
	if(q3=="")
		{
		alert("货场地址不能为空！");	
		return false;
	}
	if(!tmp.test(strmsg)||strmsg<0||strmsg=="")
	{
		alert("请输入正确的货场面积！");
		return false;
	}
	
	var c51=document.getElementById("j51").checked;
	var c52=document.getElementById("j52").checked;
	if((c51==false)&&(c52==false))
		{
		alert("请选择是否室内！");	
		return false;
	}
	var c61=document.getElementById("j61").checked;
	var c62=document.getElementById("j62").checked;
	if((c61==false)&&(c62==false))
		{
		alert("请选择是否允许危险品！");	
		return false;
	}
}


