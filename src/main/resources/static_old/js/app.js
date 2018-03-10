jQuery(document).ready(function(){
	jQuery('.navbar-toggler').click(function(){
		var target = jQuery(this).attr('data-target');
		jQuery(target).toggleClass('active');
	});
	jQuery('.navbar-close').click(function(){
		var target = jQuery(this).attr('data-target');
		jQuery(target).removeClass('active');
	});
	jQuery('.popup-youtube, .popup-vimeo, .popup-gmaps').magnificPopup({
        disableOn: 700,
        type: 'iframe',
        mainClass: 'mfp-fade',
        removalDelay: 160,
        preloader: false,
		iframe: {
            patterns: {
                youtube_short: {
                  index: 'youtu.be/',
                  id: 'youtu.be/',
                  src: 'http://www.youtube.com/embed/%id%?autoplay=1'
                }
            }
        },
        fixedContentPos: false
    });
	jQuery(".chosen-select").chosen({width:"100%"}); 
	jQuery('#editor-container').summernote();
	   
	jQuery('body').magnificPopup({
		type: 'image',
		delegate: 'a.mfp-gallery',
		fixedContentPos: true,
		fixedBgPos: true,
		overflowY: 'auto',
		closeBtnInside: false,
		preloader: true,
		removalDelay: 0,
		mainClass: 'mfp-fade',
		gallery: {
			enabled: true
		}
	}); 
});