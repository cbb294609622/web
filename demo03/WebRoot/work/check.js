
	/* 
		全选
		1.使用checked属性来控制
		2.让四个复选框都有checked属性
		3.获取四个复选框
		4.设置每一个复选框checked属性。	
		
	*/


	function seOffOn(){
		var checks = document.getElementById("boxID");
		if(checks.checked == true){
			allBtn();
		}else{
			clearBtn();
		}
	}

	
	function allBtn(){
		//获得四个复选框
		var checks = document.getElementsByName("love");
		// 循环便利 获得每一个复选框对象，然后去设置对象的属性checked。
		for(var i = 0 ; i < checks.length ;i++){
			//每循环一次获得一个input标签对象
			var chec = checks[i];
			
			//操作标签在内存中的对象
			chec.checked = true;
			//在标签内添加属性
			//chec.setAttribute("checked","checked");
		}
	}
	function clearBtn(){
		//获得四个复选框
		var checks = document.getElementsByName("love");
		// 循环便利 获得每一个复选框对象，然后去设置对象的属性checked。
		for(var i = 0 ; i < checks.length ;i++){
			//每循环一次获得一个input标签对象
			var chec = checks[i];
			chec.checked = false;
		}
	}
	function reverseBtn(){
		//获得四个复选框
		var checks = document.getElementsByName("love");
		// 循环便利 获得每一个复选框对象，然后去设置对象的属性checked。
		for(var i = 0 ; i < checks.length ;i++){
			//每循环一次获得一个input标签对象
			var chec = checks[i];
			/*if(chec.checked == true){
				chec.checked = false;
			}else{
				chec.checked = true;
			}*/
			//取反
			chec.checked = !chec.checked;
		}
	}