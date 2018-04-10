/* MyFirstJavascript.js
 * 
 * This is a Javascript file.
 * 
*/

function showAlert(user) {
	var textEl = document.getElementById("inbox");
	console.log(user + ", this is an alert.\nYour message: " + textEl.value);
	
	var divEl = document.getElementById("cont1");
	divEl.innerText=textEl.value;
	divEl.style.backgroundColor="purple";
}

function loadFunction() {
	console.log("Page loaded.");
}

//hide
$(document).ready(function() {
    $('#hideButton').click(function(event) {
//    	console.log($('#cont1').html())
        if($("#cont1").css("height") > "0px") {
        	//hide
    		$('#cont1')
    		.animate(
               	{ height: 0 }, {
                    duration: 'slow',
                    easing: 'easeOutQuad'
                });
    		$('#cont1').css("font-size", "0px");
        }
        else {
        	//expand
        	$("#cont1")
            .animate(
                { height: 100 }, {
                    duration: 'slow',
                    easing: 'easeOutQuad'
                });
        	$("#cont1").css("font-size", "16px");
        }
    	
    });
});

$(document).ready(function() {
	var gBut = $('#gradesButton');
	gBut.click(function(event) {
//		console.log("John Cena.")
		$('#gradesTab')
		.animate(
			{ height: 'toggle' }, {
				duration: 'slow',
				easing: 'easeOutQuad'
			});
		if(gBut.attr('value') == "Hide Table") {
			gBut.attr('value', "Show Table");
		}
		else {
			gBut.attr("value", "Hide Table");
		}
	});
});

$(document).ready(function() {
	var sBox = $('#searchBox');
	sBox.keyup(function(event) {
		var input = sBox.val().toUpperCase();
		
//		console.log("Input: " + input);
		
		//search rows
		//--collapse row
//		$('#infoTable tr').each(function() {
		$('#infoTable .classCol').each(function() {
			if($(this).html().substring(0, input.length) != input) {
				//hide row
				$(this).parent().hide();
			}
			else {
				//show row
				$(this).parent().show();
			}
//			console.log($(this).html().substring(0, input.length))
		})
	});
});
