// $.noConflict();
	
	/**********Vertical Slide*********/
	
	$('#nav li').on('click', function(e) {
	  $this = $(this);
	  e.stopPropagation(); 

	  if($this.has('ul').length) {
		e.preventDefault();
		var visibleUL = $('#nav').find('ul:visible').length; 
		var ele_class = $('ul', this).attr("class");
		if(ele_class != 'sub-menu opened')
		{
			$('#nav').find('ul:visible').slideToggle("normal");
			$('#nav').find('ul:visible').removeClass("opened");
			$('.icon-angle-down').addClass("closing");
			$('.closing').removeClass("icon-angle-down");
			$('.closing').addClass("icon-angle-left");
			$('.icon-angle-left').removeClass("closing");
		}
		$('ul', this).slideToggle("normal");
		if(ele_class == 'sub-menu opened')
		{
			$('ul', this).removeClass("opened");
			$('.arrow', this).removeClass("icon-angle-down");
			$('.arrow', this).addClass("icon-angle-left");
		}
		else
		{
			$('ul', this).addClass("opened");
			$('.arrow', this).removeClass("icon-angle-left");
			$('.arrow', this).addClass("icon-angle-down");
		}
	  } 

});

/**********Horizontal Slide for i-phone*********/

$(document).ready(function(){
  $(".icon-reorder").on("click", function(e){
    e.preventDefault();
      var distance = $('.page-content').css('left');
      var elm_class = $(".icon-reorder").attr("class");
      if(elm_class=='icon-reorder') {
		$(this).addClass("open");
        $('.left-nav').animate({width: 'toggle'});
      } else {
		 $(".icon-reorder").removeClass("open");
        $('.left-nav').animate({width: 'toggle'});
      }
  });
});