/* 
		选择左边条目添加到右边
		
 	*/	
 	
 	document.getElementById("add").onclick = function(){
		//1.首先判断那几个被选中。
		//先获取select1下所有子节点
		//先获取select1
		var select1 = document.getElementById("select1");
		var select2 = document.getElementById("select2");
		//获取select1下所有子节点
		var options = select1.getElementsByTagName("option");
		//循环遍历 判断是否被选中
		for(var i = 0 ; i < options.length;i++){
			//获取每一个option
			var opt = options[i];
			//判断是否被选中
			if(opt.selected == true){
				//添加到select2中
				select2.appendChild(opt);
				i--;
			}
		}
	};
 	//全部添加到右边
 	document.getElementById("add_all").onclick = function(){
		var select1 = document.getElementById("select1");
		var select2 = document.getElementById("select2");
		var options = select1.getElementsByTagName("option");
		//循环遍历 添加
		for(var i = 0 ; i < options.length;i++){
			//获取每一个option
			var opt = options[i];
			//全部添加到右边
			select2.appendChild(opt);
			i--;
		}
	};
 	//从右向左
	document.getElementById("remove").onclick = function(){
		//1.首先判断那几个被选中。
		//先获取select1下所有子节点
		//先获取select1
		var select1 = document.getElementById("select1");
		var select2 = document.getElementById("select2");
		//获取select1下所有子节点
		var options = select2.getElementsByTagName("option");
		//循环遍历 判断是否被选中
		for(var i = 0 ; i < options.length;i++){
			//获取每一个option
			var opt = options[i];
			//判断是否被选中
			if(opt.selected == true){
				//添加到select2中
				select1.appendChild(opt);
				i--;
			}
		}
	};
	
	
	//全部添加到右边
 	document.getElementById("remove_all").onclick = function(){
		var select1 = document.getElementById("select1");
		var select2 = document.getElementById("select2");
		var options = select2.getElementsByTagName("option");
		//循环遍历 添加
		for(var i = 0 ; i < options.length;i++){
			//获取每一个option
			var opt = options[i];
			//全部添加到右边
			select1.appendChild(opt);
			i--;
		}
	};
	
	//双击 添加
	
	document.getElementById("select1").ondblclick = function(){
		//1.首先判断那几个被选中。
		//先获取select1下所有子节点
		//先获取select1
		var select1 = document.getElementById("select1");
		var select2 = document.getElementById("select2");
		//获取select1下所有子节点
		var options = select1.getElementsByTagName("option");
		//循环遍历 判断是否被选中
		for(var i = 0 ; i < options.length;i++){
			//获取每一个option
			var opt = options[i];
			//判断是否被选中
			if(opt.selected == true){
				//添加到select2中
				select2.appendChild(opt);
				i--;
			}
		}
	};
	document.getElementById("select2").ondblclick = function(){
		//1.首先判断那几个被选中。
		//先获取select1下所有子节点
		//先获取select1
		var select1 = document.getElementById("select1");
		var select2 = document.getElementById("select2");
		//获取select1下所有子节点
		var options = select2.getElementsByTagName("option");
		//循环遍历 判断是否被选中
		for(var i = 0 ; i < options.length;i++){
			//获取每一个option
			var opt = options[i];
			//判断是否被选中
			if(opt.selected == true){
				//添加到select2中
				select1.appendChild(opt);
				i--;
			}
		}
	};