
	names_struct = [ 'apskritis', 'apskrities_id', 'rajonas', 'rajono_id', 
					'kvad_kom' ,'kaina_nuo_kom' ,'kaina_iki_kom' ,'kvad_gyv', 'kaina_nuo_gyv' ,'kaina_iki_gyv', 'flag_miesto' ];

	function toStruct( names, duom_arr ) {
	
		new_struct = [];
		
		for ( i = 0; i < duom_arr.length; i++  ) {
		
			new_struct1 = new Object();
		
			for( t = 0; t < names.length; t++ ) {
			
				new_struct1 [ names [ t ] ] = duom_arr [ i ] [ t ];
			}
			new_struct.push ( new_struct1 );
		}
		return new_struct;
	}