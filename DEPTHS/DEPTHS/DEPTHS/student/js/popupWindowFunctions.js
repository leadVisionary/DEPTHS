function popupWindow(url) {
		var left = (screen.width - 1000)/2;
		left = left<0?0:left;
		var top  = (screen.height - 980)/2;
		top = top<0?0:top;
		window640 = window.open(url,"window640"
								,"location=0,scrollbars=1,menubar=0,toolbar=0,status=1,resizable=1,directories=0,left="+left+",top="+top+",width=1000,height=880");
		
	}
	function popupSmallWindow(url) {
		var left = (screen.width - 650)/2;
		left = left<0?0:left;
		var top  = (screen.height - 500)/2;
		top = top<0?0:top;
		window640 = window.open(url,"window640"
								,"location=0,scrollbars=1,menubar=0,toolbar=0,status=1,resizable=1,directories=0,left="+left+",top="+top+",width=650,height=450");
		
	}
	function popupMiddleWindow(url) {
		var left = (screen.width - 650)/2;
		left = left<0?0:left;
		var top  = (screen.height - 500)/2;
		top = top<0?0:top;
		window640 = window.open(url,"window640"
								,"location=0,scrollbars=1,menubar=0,toolbar=0,status=1,resizable=1,directories=0,left="+left+",top="+top+",width=650,height=550");
		
	}