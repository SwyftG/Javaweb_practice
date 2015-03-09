function pan() {
	var name = document.getElementById("name").value;

	var checkNum = 0;
	var mima1 = document.getElementById("pwd0").value;
	var mima2 = document.getElementById("pwd").value;
	var mima3 =	document.getElementById("pwd1").value;
	if (mima1 != mima2) {
		alert("输入的原密码错误！");
		return false;
	}
	if(mima3==""){
		alert("密码不能为空");
		return false;
	}
	for (i = 0; i < form.quanxian.length; i++) {
		if (form.quanxian[i].checked) {
			checkNum++;
		}
	}
	if (checkNum == 0) {
		alert("权限不能为空");
		return false;
	}

	if (name == "") {
		alert("用户名未输入！");
		return false;
	}



	else {
		return true;
	}

}