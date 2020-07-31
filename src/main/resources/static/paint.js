

	function ValuePoints( paint_size_y, list, field_y ) {
	
		value_points = [];
		
		if ( list.length > 0 ) { 
	
			max_y = list [ 0 ][ field_y ]; 
			min_y = list [ 0 ][ field_y ]; 
		
			for ( i = 1; i < list.length; i++ ) {
			
				if ( list [ i ][ field_y ] > max_y ) {
				
					max_y = list [ i ][ field_y ];
				}
				
				if ( list [ i ][ field_y ] < min_y ) {
				
					min_y = list [ i ][ field_y ];
				}				
			}
			
			size_y = max_y - min_y;
			
			point_y = size_y / paint_size_y;
			
			console.log ( point_y );
			
			for ( i = 0; i < list.length; i++ ) {
			
				value_points.push ( ( list [ i ][ field_y ]  - min_y ) / point_y ); 
			}			
		}
		
		return value_points;
	}


	function drawLine ( ctx, x1, y1, x2, y2 ) {
	
			  // Reset the current path
			  ctx.beginPath() ; 

			  ctx.moveTo ( x1, y1 );

			  ctx.lineTo ( x2, y2 );
			  
			  // Make the line visible
			  ctx.stroke();	
	}
	
	function drawRect ( ctx, x1, y1, x2, y2, fill_style ) {

		ctx.beginPath();
		ctx.rect( x1, y1, x2, y2 );
		ctx.fillStyle = fill_style;
		ctx.fill();
	}

	function Paint( id_canvas, size_x, size_y, list, field_x, field_y, type ) {
	
		var canvas = document.getElementById( id_canvas );
		
		//Always check for properties and methods, to make sure your code doesn't break in other browsers.
		
		if (canvas.getContext) {
		
			  plot_size_x = size_x * 0.8;
			  plot_size_y = size_y * 0.8;
			  
			  space_top = size_y * 0.1;
			  space_left = size_x * 0.1;
			  
			  space_bottom = space_top;
		
			  var context = canvas.getContext('2d');
			  
			  alert ( 'bla x' );

			  drawLine ( context, space_left, size_y - space_bottom, space_left, space_top);
			  
			  drawLine ( context, space_left, size_y - space_bottom, space_left + plot_size_x, size_y - space_bottom );
	  
			  context.font = 'italic 400 12px, sans-serif';			  
			  
			  if ( type == 'linear' ) {
			  
			  		step_x = plot_size_x / ( list.length + 1 );
			  		
			  		x = space_left + step_x;
			  		
			  		list_paint_vals = ValuePoints ( plot_size_y, list, field_y );
			  		
			  		for ( i = 0; i < list.length; i++ ) {
			  		
			  			 context.fillText ( list [ i ] [ field_x ], x, size_y -  2 * space_bottom / 3, step_x - 7 );
			  			 console.log ( Math.round ( x - 7 ), Math.round ( space_top + plot_size_y - list_paint_vals [ i ] ), 14, Math.round ( space_top + plot_size_y ) );
			  			 drawRect ( context, Math.round ( x - 7 ),  Math.round ( space_top + plot_size_y - list_paint_vals [ i ] ), 14, Math.round ( space_top + plot_size_y ) -  Math.round ( space_top + plot_size_y - list_paint_vals [ i ] ), 'red' );
			  			 x += step_x;
			  		}
			  }  
			  
		} else {
		
			alert ( 'browser doesn`t support canvas' );
		}
	
	}