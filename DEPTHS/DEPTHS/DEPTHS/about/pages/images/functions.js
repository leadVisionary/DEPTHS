function popupWindow(url) {
		var left = (screen.width - 900)/2;
left = left<0?0:left;
var top  = (screen.height - 880)/2;
top = top<0?0:top;
window640 = window.open(url,"window640"
,"location=0,scrollbars=1,menubar=0,toolbar=0,status=1,resizable=1,directories=0,left=0,top=0,width=1000,height=880");
window640.moveTo(10,0);
	}
	function popupSmallWindow(url) {
		var left = (screen.width - 650)/2;
left = left<0?0:left;
var top  = (screen.height - 500)/2;
top = top<0?0:top;
window640 = window.open(url,"window640"
,"location=0,scrollbars=1,menubar=0,toolbar=0,status=1,resizable=1,directories=0,left=0,top=0,width=650,height=450");
window640.moveTo(left,top);
	}


function popup(url,width,height) {
		args=width?"width="+width+",":"width=300,";
		args+=height?"height="+height:"height=400";
		args+=",scrollbars=1,status=1,resizable=1,top=0,left=0,location=no toolbar=no";
		win=window.open(url,'win',args);
		win.focus();
	}
