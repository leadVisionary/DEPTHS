

var target_box = "";
var source_box = "";


function update_box(source_box,target_box)
{
	try{
		var selected_item_text;
		var selected_item_value;
		for(var i=0; i<document.forms.length; i++)
		{
			for (var j=0; j<document.forms[i].elements.length; j++)
			{
				if(document.forms[i].elements[j].name == source_box)
					{
						var index = document.forms[i].elements[j].selectedIndex;
						if (index == -1)
						{
							alert("You have to choose at least one item!");
						}
						else
						{
							selected_item_text = document.forms[i].elements[j].options[index].text;
							selected_item_value = document.forms[i].elements[j].options[index].value;
							var oOption = document.createElement("OPTION");
							oOption.text = selected_item_text;
							oOption.value = selected_item_value;
							for (var k=0; k<document.forms[i].elements.length; k++)
			                {
				                if(document.forms[i].elements[k].name == target_box)
				                {
							        document.forms[i].elements[k].add(oOption);
									document.forms[i].elements[j].remove(index);
							    }
							}
						}
					}
			}
		}

	}
	catch (exception){
		alert("ERROR in Function");

	}
}






function go_update_box()
{
	try
	{

		if (go_update_box.arguments.length == 1)
			{
				target_box = go_update_box.arguments[0];
				alert("Wrong number of parameters");
				return false;

			}
			else if ( go_update_box.arguments.length > 1)
			{
				source_box = go_update_box.arguments[0];
				for (var i=1; i < go_update_box.arguments.length; i++)
				{
					target_box = go_update_box.arguments[i];
					update_box(source_box,target_box);

				}
				return false;
			}

	}
	catch (exception){
		alert("Error in JS function!");
		return true;
	}
}
function submitListValues()
    {
        var lst = document.getElementById("selectedGroups");
        var items = lst.options;

        for(i = 0; i < items.length; i++)
        {
            items[i].selected = true;
        }
        document.form1.submit();
    }
