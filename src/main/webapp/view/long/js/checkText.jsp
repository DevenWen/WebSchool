//校验数据
	function checkText(num1,num2,id){
		var grade=document.getElementById(id).value; 
		
		//var grade=document.getElementsByName("test")[0].value;
		if(!isNaN(grade)){
			if(grade >= num1 && grade<=num2){
				showInfo2();
			}
			else{
				showInfo1();
			}
		}else{
			showInfo1();
		}
	
	}
	
	//显示提示信息
	function showInfo1(){
		var message=document.getElementById("message");
		message.innerHTML="请输入合理的数据值".fontcolor("red");
		
	}
	function showInfo2(){
		var message=document.getElementById("message");
		message.innerHTML="";
	}