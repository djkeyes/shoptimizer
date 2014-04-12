$(document).ready(function() {
function popup(x,y) {
	var fontsize = ((Math.random()*10) + 100).toFixed(); //vary size
	$newdiv = $('#flying').css({
		'size': fontsize + 'px'
		});
} 

//set position within screen
    var posx = (Math.random() * ($(document).width() - $('#flying').getWidth())).toFixed();
    var posy = (Math.random() * ($(document).height() - $('#flying').getHeight())).toFixed();

    $newdiv.css({
        'position':'absolute',
        'left':posx+'px',
        'top':posy+'px',
        'display':'none'
    }).appendTo('body').fadeIn(100).delay(1000).fadeOut(500, function(){
      $(this).remove();
      popup(); 
    }); 
})();
}