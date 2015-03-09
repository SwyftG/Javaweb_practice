function pan(){
			var mima1=document.getElementById("pwd0").value;
			var mima2=document.getElementById("pwd1").value;
			if(mima1!=mima2){
				alert("密码不一致");
				return false;
			}
			return true;
		}