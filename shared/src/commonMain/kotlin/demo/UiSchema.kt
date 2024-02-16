package demo

//language=JSON
val UI_SCHEMA = """{
  "type": "uiSchema",
  "id": "4f00cd9f-7716-4e0c-9c9d-a76977c2b993",
  "title": "Demo UI",
  "description": "An example ui schema",
  "items": [
    {
      "type": "page",
      "title": "Text elements",
      "icon": "TextFields",
      "items": [
        {
          "type": "section",
          "title": "Labels",
          "items": [
            {
              "type": "label",
              "title": "This is a heading label",
              "style": "heading"
            },
            {
              "type": "label",
              "title": "This is a title label",
              "style": "title"
            },
            {
              "type": "label",
              "title": "This is a normal label",
              "style": "normal"
            }
          ]
        },
        {
          "type": "section",
          "title": "Textfields",
          "items": [
            {
              "type": "text",
              "title": "A text field",
              "property": "text.text1"
            },
            {
              "type": "label",
              "title": "Number of characters entered: {{ Len(text.text1) }}"
            },
            {
              "type": "text",
              "title": "A text area.",
              "property": "text.text2",
              "multiline": true
            },
            {
              "type": "text",
              "title": "A required text field",
              "property": "text.text3",
              "required": true
            }
          ]
        }
      ]
    },
    {
      "type": "page",
      "title": "Options",
      "icon": "RadioButtonChecked",
      "name": "options",
      "items": [
        {
          "type": "section",
          "title": "On/Off",
          "items": [
            {
              "type": "checkbox",
              "title": "A checkbox",
              "property": "options.bool1"
            },
            {
              "type": "label",
              "title": "Checkbox is {{ options.bool1 ? 'on' : 'off' }}"
            },
            {
              "type": "switch",
              "title": "A toggle switch",
              "property": "options.bool2"
            },
            {
              "type": "label",
              "title": "Switch is {{ options.bool2 ? 'on' : 'off' }}"
            }
          ]
        },
        {
          "type": "section",
          "title": "Options",
          "name": "options",
          "items": [
            {
              "type": "radios",
              "title": "Radio buttons. Choose your option:",
              "property": "options.enum1",
              "enumLabels": {
                "1": "First option",
                "2": "Another options",
                "3": "Third option",
                "4": "And the last option"
              },
              "name": "radios"
            },
            {
              "type": "label",
              "title": "Your selected option: {{ Int(options.enum1) }} - {{ OptionsLabel('options.options.radios', options.enum1) }}"
            },
            {
              "type": "dropdown",
              "title": "Options in a dropdown menu",
              "property": "options.enum2",
              "enumLabels": {
                "1": "First option",
                "2": "Another options",
                "3": "Third option",
                "4": "And the last option"
              },
              "name": "dropdown"
            },
            {
              "type": "label",
              "title": "Your option: {{ Int(options.enum2) }} - {{ OptionsLabel('options.options.dropdown', options.enum2) }}"
            }
          ]
        }
      ]
    },
    {
      "type": "page",
      "title": "Numbers",
      "icon": "Pin",
      "items": [
        {
          "type": "section",
          "title": "Integer value fields",
          "items": [
            {
              "type": "integer",
              "title": "An integer input",
              "property": "numbers.integer"
            },
            {
              "type": "slider",
              "title": "The same integer as a slider",
              "property": "numbers.integer"
            },
            {
              "type": "label",
              "title": "A calculated integer data value {{ numbers.integerExpression }}"
            },
            {
              "type": "row",
              "items": [
                {
                  "type": "button",
                  "title": "Decrement integer",
                  "icon": "ArrowLeft",
                  "onClick": [
                    "Dispatch('SetValue', 'numbers.integer', numbers.integer - 1)"
                  ]
                },
                {
                  "type": "button",
                  "title": "Increment integer",
                  "icon": "ArrowRight",
                  "onClick": [
                    "Dispatch('SetValue', 'numbers.integer', numbers.integer + 1)"
                  ]
                }
              ]
            },
            {
              "type": "number",
              "title": "A number input",
              "property": "numbers.number"
            }
          ]
        }
      ]
    },
    {
      "type": "page",
      "title": "Date and Times",
      "icon": "CalendarMonth",
      "items": [
        {
          "type": "datetime",
          "title": "Date and time",
          "property": "dateAndTime.dateTime"
        },
        {
          "type": "datetime",
          "title": "Only date",
          "property": "dateAndTime.date"
        },
        {
          "type": "datetime",
          "title": "Only time",
          "property": "dateAndTime.time"
        }
      ]
    },
    {
      "type": "page",
      "title": "Lists",
      "icon": "TableRows",
      "name": "lists",
      "items": [
        {
          "type": "label",
          "title": "Click on '+' to add items, on '-' to remove items",
          "style": "title"
        },
        {
          "type": "list",
          "property": "list",
          "name": "list",
          "items": [
            {
              "type": "number",
              "title": "Number 1",
              "property": "num1"
            },
            {
              "type": "number",
              "title": "Number 2",
              "property": "num2"
            },
            {
              "type": "dropdown",
              "title": "Factor",
              "property": "factor",
              "enumLabels": {
                "x1": "Unit sum * 1",
                "x2": "Unit sum * 2",
                "x3": "Unit sum * 3",
                "x4": "Unit sum * 4"
              },
              "name": "factor",
              "emptyOption": false
            },
            {
              "type": "label",
              "title": "Unit sum {{ num1 + num2 }} - Total sum: {{ sum }}"
            }
          ]
        },
        {
          "type": "label",
          "title": "Total: {{ total }}"
        }
      ]
    },
    {
      "type": "page",
      "title": "Properties",
      "icon": "SettingsApplications",
      "name": "properties",
      "items": [
        {
          "type": "text",
          "title": "Text field",
          "property": "properties.text",
          "enabled": "properties.enabled",
          "visible": "properties.visible",
          "required": "properties.required"
        },
        {
          "type": "checkbox",
          "title": "Enabled",
          "property": "properties.enabled"
        },
        {
          "type": "checkbox",
          "title": "Visible",
          "property": "properties.visible"
        },
        {
          "type": "checkbox",
          "title": "Required",
          "property": "properties.required"
        }
      ]
    },
    {
      "type": "page",
      "title": "Calculations",
      "icon": "Calculate",
      "name": "calculations",
      "items": [
        {
          "type": "number",
          "title": "x",
          "property": "calculations.x"
        },
        {
          "type": "number",
          "title": "y",
          "property": "calculations.y"
        },
        {
          "type": "label",
          "title": "Nz(x, 42) = {{ Nz(calculations.x, 42) }}"
        },
        {
          "type": "label",
          "title": "x + y = {{ calculations.x + calculations.y }}"
        },
        {
          "type": "label",
          "title": "x * y = {{ calculations.x * calculations.y }}"
        },
        {
          "type": "label",
          "title": "x ^ y = {{ calculations.x ^ calculations.y }}"
        },
        {
          "type": "label",
          "title": "sin(x) = {{ Sin(calculations.x) }}"
        },
        {
          "type": "label",
          "title": "x > y = {{ calculations.x > calculations.y }}"
        },
        {
          "type": "label",
          "title": "x == y ? 'equal' : 'non equal' = {{ calculations.x == calculations.y ? 'equal' : 'non equal' }}"
        }
      ]
    },
    {
      "type": "page",
      "title": "Structured Pages",
      "items": [
        {
          "type": "page",
          "title": "Level 1.1",
          "items": [
            {
              "type": "page",
              "title": "Level 2.1",
              "items": [
                {
                  "type": "page",
                  "title": "Level 2.1.1"
                }
              ]
            },
            {
              "type": "page",
              "title": "Level 2.2"
            },
            {
              "type": "page",
              "title": "Level 2.3"
            }
          ]
        },
        {
          "type": "page",
          "title": "Level 1.2"
        }
      ]
    }
  ]
}"""
