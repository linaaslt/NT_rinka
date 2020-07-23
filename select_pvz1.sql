SELECT SQL_CALC_FOUND_ROWS  

	`apskritys`.`pav` AS `apskritis` 
	, `pastatai`.`kvad_kom` AS `kvad_kom` 
	, `pastatai`.`kaina_nuo_kom` AS `kaina_nuo_kom` 
	, `pastatai`.`kaina_iki_kom` AS `kaina_iki_kom` 
	, `pastatai`.`kvad_gyv` AS `kvad_gyv` 
	, `pastatai`.`kaina_nuo_gyv` AS `kaina_nuo_gyv` 
	, `pastatai`.`kaina_iki_gyv` AS `kaina_iki_gyv` 
	, `rajonai`.`flag_miesto` AS `flag_miesto`
	FROM 
		`pastatai` 
	LEFT JOIN 		
		`rajonai` ON ( 
			`pastatai`.`id_rajono`=`rajonai`.`id` 
		) 
	LEFT JOIN 		
		`apskritys` ON ( 
			`rajonai`.`id_apskrities`=`apskritys`.`id` 
		) 
	WHERE 
		1 AND 1 
	GROUP BY 
		`apskritys`.`id`  
	ORDER BY 
		`apskritys`.`pav` DESC 
