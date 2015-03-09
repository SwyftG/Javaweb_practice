/*
作者：刘嘉杰
时间：2011年7月20日
模块功能：货运调度安排
*/

   //时间的逻辑
function test()
       {
  
          var day1=document.getElementById("day1").value;
          var day2=document.getElementById("day2").value;
          var month1=document.getElementById("month1").value;
          var month2=document.getElementById("month2").value;
          var year1=document.getElementById("year1").value;     
          var year2=document.getElementById("year2").value;     
                if(year1>year2){
                        alert("发货时间与到货时间有误");
                        return false;
                }
                if(year1==year2&&month1>month2){
                        alert("发货时间与到货时间有误");
                        return false;
                }
                if(year1==year2&&month1==month2&&day1>day2){
   						alert("发货时间与到货时间有误");
   						return false;
                } 
             	else{
                	return true;
                	}      	
		}
           
             
     //时间的动态下拉列表框           
		function fillDate(j)
	{
		document.getElementById("day"+j).options.length=0;
		var ddlYear = document.getElementById("year"+j).value;
		var ddlMonth = document.getElementById("month"+j).value;
		var ddlDate = document.getElementById("day"+j);
		var opt = null;
		
		if(ddlMonth == 1||ddlMonth == 3||ddlMonth == 5||ddlMonth == 7||ddlMonth== 8||ddlMonth == 10||ddlMonth == 12)
			days = 31;
		if(ddlMonth == 4||ddlMonth == 6||ddlMonth == 9||ddlMonth== 11)
			days = 30;
		if(ddlMonth == 2)
		{
			if(ddlYear%4==0&&ddlYear%100==0)
				days = 29;
			else
				days =28;
		}	
		for(var i=1;i<=days;i++)
		{
			opt = document.createElement("OPTION");
			opt.value = i;
			opt.innerText = i+"日";
			ddlDate.appendChild(opt);
		}
	}
		
		function fillSelect(j){
		var ddlYear = document.getElementById("year"+j);
		var ddlMonth = document.getElementById("month"+j);
		var ddlDate = document.getElementById("day"+j);
		var opt = null;
		var curDay = new Date();
		var year = curDay.getFullYear();
		for(var i=-5;i<=5;i++){
			opt = document.createElement("OPTION");
			opt.value= year + i;
			opt.innerText=(year+i)+"年";
			ddlYear.appendChild(opt);
		}
		ddlYear.value = curDay.getFullYear();
		
		for(var i=1;i<=12;i++)
		{
			opt = document.createElement("OPTION");
			opt.value= i;
			opt.innerText=i+"月";
			ddlMonth.appendChild(opt);
		}
		ddlMonth.value = curDay.getMonth()+1;
		
		var ddlYear = document.getElementById("year"+j).value;
		var ddlMonth= document.getElementById("month"+j).value;
		if(ddlMonth == 1||ddlMonth == 3||ddlMonth == 5||ddlMonth == 7||ddlMonth == 8||ddlMonth == 10||ddlMonth == 12)
			days = 31;
		if(ddlMonth == 4||ddlMonth == 6||ddlMonth == 9||ddlMonth == 11)
			days = 30;
		if(ddlMonth == 2)
		{
			if(ddlYear%4==0&&ddlYear%100==0)
				days = 29;
			else
				days =28;
		}	
		for(var i=1;i<=days;i++)
		{
			opt = document.createElement("OPTION");
			opt.value = i;
			opt.innerText = i+"日";
			ddlDate.appendChild(opt);
		}
	}

