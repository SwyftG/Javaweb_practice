
function canSubmit()
{

	if(document.getElementById("place").value == "")
		{
		alert("place不能为空");
		return false;
		}
	if(document.getElementById("weight").value == "")
		{
		alert("weight不能为空");
		return false;
		}
	if(document.getElementById("status").value == "")
		{
		alert("status不能为空");
		return false;
		}
	
	return true;
	

	
	
}
function Submit(){

	if(document.getElementById("weight").value == "")
		{
		alert("weight不能为空");
		return false;
		}
	if(document.getElementById("status").value == "")
		{
		alert("status不能为空");
		return false;
		}
	
	return true;
	

	
	
}

		




