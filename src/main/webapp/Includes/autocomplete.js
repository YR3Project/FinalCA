
var options = {
	url: "Includes/countries.json",

	getValue: "name",

	list: {
		match: {
			enabled: true
		}
	}
};

$("#provider-json").easyAutocomplete(options);