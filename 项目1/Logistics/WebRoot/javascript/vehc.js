function test(){
	var c0=document.getElementById("vf").value;
	var c1=document.getElementById("vl").value;
	var c2=document.getElementsByName("ot").value;
	var c3=document.getElementById("oc").value;
	var c4=document.getElementsByName("vt").value;
	var c5=document.getElementById("lc").value;
	var c6=document.getElementById("vs1").checked;
	var c7=document.getElementById("vs2").checked;
	var tmp=/^[0-9]*$/;
	
	if(c0==""){
		alert("车辆型号不能为空！");
		return false;
	}
	if(c1==""){
		alert("车辆牌照不能为空！");
		return false;
	}
	
	if(c2==""){
		alert("燃油类型不能为空！");
		return false;
	}
	if(c3==""){
		alert("耗油量不能为空！");
		return false;
	}
	if(c4==""){
		alert("车辆类型不能为空！");
		return false;
	}
	if(c5==""){
		alert("载重量不能为空！");
		return false;
	}
	if((c6==false)&&(c7==false)){
		alert("车辆特种不能为空！");
		return false;
	}
	if(!tmp.test(c3)){
		alert("耗油量必须为数字！");
		return false;
	}
	if(!tmp.test(c5)){
		alert("载重量必须为数字！");
		return false;
	}
	return true;	
}
	
