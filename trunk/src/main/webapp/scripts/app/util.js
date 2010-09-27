/**
 * Resize the table width based on the selected columns.
 * @param columns
 * @return
 */
function getGridWidth (columns) {
	var maxWidth = parseInt(screen.availWidth) - 100;
	var finalWidth = 'auto';
	var width = 0;
	if (columns != undefined && columns.length > 0) {
		$.each(columns, function() {
			if (!this.hide) {
				width = width + this.width + 12;
			}
		});
	}
	
	if (width > 0) {
		if (width > maxWidth) {
			finalWidth = maxWidth; 
		} else {
			finalWidth = width + 2;
		}		
	}
	return finalWidth;
}


function clear_form_elements(ele) {
    $(ele).find(':input').each(function() {
        switch(this.type) {
            case 'password':
            case 'select-multiple':
            case 'select-one':
            case 'text':
            case 'textarea':
                $(this).val('');
                break;
            case 'checkbox':
            case 'radio':
                this.checked = false;
        }
    });
}
