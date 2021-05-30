$(document).ready(function(){
 
	$('.subir').click(function(){
		$('body, html').animate({
			scrollTop: '0px'
		}, 300);
	});
 
	$(window).scroll(function(){
		if( $(this).scrollTop() > 0 ){
			$('.subir').slideDown(300);
		} else {
			$('.subir').slideUp(300);
		}
	});
 
});