function add() {
	var name = document.getElementById("name").value;
	var mima = document.getElementById("pwd").value;
	var checkNum = 0;

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
		alert("用户名不能为空");
		return false;
	}

	if (mima == "") {
		alert("密码不能为空");
		return false;
	}

	else {
		return true;
	}
}