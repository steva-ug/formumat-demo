package demo

//language=JSON
val UI_SCHEMA = """{
  "id": "4f00cd9f-7716-4e0c-9c9d-a76977c2b993",
  "type": "uiSchema",
  "items": [
    {
      "icon": "TextFields",
      "type": "page",
      "items": [
        {
          "type": "section",
          "items": [
            {
              "type": "label",
              "style": "heading",
              "title": {
                "__": "This is a heading label",
                "de": "Dies ist eine Kopfzeile"
              }
            },
            {
              "type": "label",
              "style": "title",
              "title": {
                "__": "This is a title label",
                "de": "Dies ist eine Überschrift"
              }
            },
            {
              "type": "label",
              "style": "normal",
              "title": {
                "__": "This is a normal label",
                "de": "Dies ist ein normales Label"
              }
            }
          ],
          "title": {
            "__": "Labels",
            "de": "Label"
          }
        },
        {
          "type": "section",
          "items": [
            {
              "type": "text",
              "title": {
                "__": "A text field",
                "de": "Eine Textzeile"
              },
              "property": "text.text1"
            },
            {
              "type": "label",
              "title": {
                "__": "Number of characters entered: <%= len(text.text1) %>",
                "de": "Anzahl der eingegebenen Zeichen: <%= len(text.text1) %>"
              }
            },
            {
              "type": "text",
              "title": {
                "__": "A text area.",
                "de": "Ein Textbereich"
              },
              "property": "text.text2",
              "multiline": true
            },
            {
              "type": "text",
              "title": {
                "__": "A required text field",
                "de": "Eine Pflicht-Textzeile"
              },
              "property": "text.text3",
              "required": true
            },
            {
              "type": "text",
              "title": {
                "__": "A text with default value",
                "de": "Eine Textzeile mit einem Standardwert"
              },
              "property": "text.textDefault"
            },
            {
              "type": "text",
              "title": {
                "__": "A nested property",
                "de": "Ein verschachteltes Property"
              },
              "property": "text.nested.nestedText"
            }
          ],
          "title": {
            "__": "Textfields",
            "de": "Text Felder"
          }
        }
      ],
      "title": {
        "__": "Text elements",
        "de": "Text Elemente"
      }
    },
    {
      "icon": "RadioButtonChecked",
      "name": "options",
      "type": "page",
      "items": [
        {
          "type": "section",
          "items": [
            {
              "type": "checkbox",
              "title": {
                "__": "Eine Checkbox",
                "en": "A checkbox"
              },
              "property": "options.bool1"
            },
            {
              "type": "label",
              "title": {
                "__": "Die Checkbox ist <%= options.bool1 ? 'an' : 'aus' %>",
                "en": "Checkbox is <%= options.bool1 ? 'on' : 'off' %>"
              }
            },
            {
              "type": "switch",
              "title": {
                "__": "Ein Umschalter",
                "en": "A toggle switch"
              },
              "property": "options.bool2"
            },
            {
              "type": "label",
              "title": {
                "__": "Der Schalter ist <%= options.bool2 ? 'an' : 'aus' %>",
                "en": "Switch is <%= options.bool2 ? 'on' : 'off' %>"
              }
            }
          ],
          "title": {
            "__": "Ein/Aus",
            "en": "On/Off"
          }
        },
        {
          "name": "options",
          "type": "section",
          "items": [
            {
              "name": "radios",
              "type": "radios",
              "title": {
                "__": "Radio Buttons. Wählen Sie ihre Option:",
                "en": "Radio buttons. Choose your option:"
              },
              "property": "options.enum1",
              "enumLabels": {
                "1": {
                  "__": "Erste Option",
                  "en": "First option"
                },
                "2": {
                  "__": "Zweite Option",
                  "en": "Another options"
                },
                "3": {
                  "__": "Dritte Option",
                  "en": "Third option"
                },
                "4": {
                  "__": "Und die letzte Option",
                  "en": "And the last option"
                }
              }
            },
            {
              "type": "label",
              "title": {
                "__": "Ihre gewählte Option: <%= toInt(options.enum1) %> - <%= optionsLabel('options.options.radios', options.enum1) %>",
                "en": "Your selected option: <%= toInt(options.enum1) %> - <%= optionsLabel('options.options.radios', options.enum1) %>"
              }
            },
            {
              "name": "dropdown",
              "type": "dropdown",
              "title": {
                "__": "Optionen in einem Dropdown-Menü",
                "en": "Options in a dropdown menu"
              },
              "property": "options.enum2",
              "enumLabels": {
                "1": {
                  "__": "Erste Option",
                  "en": "First option"
                },
                "2": {
                  "__": "Zweite Option",
                  "en": "Another options"
                },
                "3": {
                  "__": "Dritte Option",
                  "en": "Third option"
                },
                "4": {
                  "__": "Und die letzte Option",
                  "en": "And the last option"
                }
              }
            },
            {
              "type": "label",
              "title": {
                "__": "Ihre gewählte Option: <%= toInt(options.enum2) %> - <%= optionsLabel('options.options.dropdown', options.enum2) %>",
                "en": "Your selected option: <%= toInt(options.enum2) %> - <%= optionsLabel('options.options.dropdown', options.enum2) %>"
              }
            }
          ],
          "title": {
            "__": "Optionen",
            "en": "Options"
          }
        }
      ],
      "title": {
        "__": "Optionen",
        "en": "Options"
      }
    },
    {
      "icon": "Pin",
      "type": "page",
      "items": [
        {
          "type": "section",
          "items": [
            {
              "type": "integer",
              "title": {
                "__": "Eine Zahleneingabe mit Standardwert",
                "en": "An integer input with default value"
              },
              "property": "numbers.integerWithDefault"
            },
            {
              "type": "integer",
              "title": {
                "__": "Eine Zahleneingabe",
                "en": "An integer input"
              },
              "property": "numbers.integer"
            },
            {
              "type": "slider",
              "title": {
                "__": "Die selbe Zahl als Slider",
                "en": "The same integer as a slider"
              },
              "property": "numbers.integer"
            },
            {
              "type": "label",
              "title": {
                "__": "Eine berechnete Zahl <%= numbers.integerExpression %>",
                "en": "A calculated integer data value <%= numbers.integerExpression %>"
              }
            },
            {
              "type": "row",
              "items": [
                {
                  "icon": "ArrowLeft",
                  "type": "button",
                  "title": {
                    "__": "Zahl verringern",
                    "en": "Decrement integer"
                  },
                  "onClick": [
                    "dispatch('SetValue', 'numbers.integer', numbers.integer - 1)"
                  ]
                },
                {
                  "icon": "ArrowRight",
                  "type": "button",
                  "title": {
                    "__": "Zahl erhöhen",
                    "en": "Increment integer"
                  },
                  "onClick": [
                    "dispatch('SetValue', 'numbers.integer', numbers.integer + 1)"
                  ]
                }
              ]
            },
            {
              "type": "number",
              "title": {
                "__": "Eine Dezimalzahleingabe",
                "en": "A number input"
              },
              "property": "numbers.number"
            }
          ],
          "title": {
            "__": "Zahleneingaben",
            "en": "Integer value fields"
          }
        }
      ],
      "title": {
        "__": "Zahlen",
        "en": "Numbers"
      }
    },
    {
      "icon": "CalendarMonth",
      "type": "page",
      "items": [
        {
          "type": "datetime",
          "title": {
            "__": "Datum und Zeit",
            "en": "Date and time"
          },
          "property": "dateAndTime.dateTime"
        },
        {
          "type": "datetime",
          "title": {
            "__": "Nur Datum",
            "en": "Only date"
          },
          "property": "dateAndTime.date"
        },
        {
          "type": "datetime",
          "title": {
            "__": "Nur Zeit",
            "en": "Only time"
          },
          "property": "dateAndTime.time"
        }
      ],
      "title": {
        "__": "Datum und Zeit",
        "en": "Date and Times"
      }
    },
    {
      "icon": "TableRows",
      "name": "lists",
      "type": "page",
      "items": [
        {
          "type": "label",
          "style": "title",
          "title": {
            "__": "Klicken Sie auf '+' um einen Eintrag hinzuzufügen und auf '-' um einen Eintrag zu löschen",
            "en": "Click on '+' to add items, on '-' to remove items"
          }
        },
        {
          "name": "list",
          "type": "list",
          "items": [
            {
              "type": "number",
              "title": {
                "__": "Nummer 1",
                "en": "Number 1"
              },
              "property": "num1"
            },
            {
              "type": "number",
              "title": {
                "__": "Nummer 2",
                "en": "Number 2"
              },
              "property": "num2"
            },
            {
              "name": "factor",
              "type": "dropdown",
              "title": {
                "__": "Faktor",
                "en": "Factor"
              },
              "property": "factor",
              "enumLabels": {
                "x1": {
                  "__": "Einzelsumme * 1",
                  "en": "Unit sum * 1"
                },
                "x2": {
                  "__": "Einzelsumme * 2",
                  "en": "Unit sum * 2"
                },
                "x3": {
                  "__": "Einzelsumme * 3",
                  "en": "Unit sum * 3"
                },
                "x4": {
                  "__": "Einzelsumme * 4",
                  "en": "Unit sum * 4"
                }
              },
              "emptyOption": false
            },
            {
              "type": "label",
              "title": {
                "__": "Einzelsumme <%= num1 + num2 %> - Gesamt: <%= sum %>",
                "en": "Unit Sum <%= num1 + num2 %> - Total sum: <%= sum %>"
              }
            }
          ],
          "property": "list"
        },
        {
          "type": "label",
          "title": {
            "__": "Gesamt: <%= total %>",
            "en": "Total: <%= total %>"
          }
        }
      ],
      "title": {
        "__": "Listen",
        "en": "Lists"
      }
    },
    {
      "icon": "SettingsApplications",
      "name": "properties",
      "type": "page",
      "items": [
        {
          "type": "text",
          "title": {
            "__": "Textfeld",
            "en": "Text field"
          },
          "enabled": "properties.enabled",
          "visible": "properties.visible",
          "property": "properties.text",
          "required": "properties.required"
        },
        {
          "type": "checkbox",
          "title": {
            "__": "Aktiv",
            "en": "Enabled"
          },
          "property": "properties.enabled"
        },
        {
          "type": "checkbox",
          "title": {
            "__": "Sichtbar",
            "en": "Visible"
          },
          "property": "properties.visible"
        },
        {
          "type": "checkbox",
          "title": {
            "__": "Pflicht",
            "en": "Required"
          },
          "property": "properties.required"
        }
      ],
      "title": {
        "__": "Eigenschaften",
        "en": "Properties"
      }
    },
    {
      "icon": "Calculate",
      "name": "calculations",
      "type": "page",
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
          "title": "Nz(x, 42) = <%= nz(calculations.x, 42) %>"
        },
        {
          "type": "label",
          "title": "x + y = <%= calculations.x + calculations.y %>"
        },
        {
          "type": "label",
          "title": "x * y = <%= calculations.x * calculations.y %>"
        },
        {
          "type": "label",
          "title": "x ^ y = <%= calculations.x ^ calculations.y %>"
        },
        {
          "type": "label",
          "title": "sin(x) = <%= sin(calculations.x) %>"
        },
        {
          "type": "label",
          "title": "x > y = <%= calculations.x > calculations.y %>"
        },
        {
          "type": "label",
          "title": {
            "__": "x == y ? 'gleich' : 'ungleich' = <%= calculations.x == calculations.y ? 'gleich' : 'ungleich' %>",
            "en": "x == y ? 'equal' : 'non equal' = <%= calculations.x == calculations.y ? 'equal' : 'non equal' %>"
          }
        }
      ],
      "title": {
        "__": "Berechnungen",
        "en": "Calculations"
      }
    },
    {
      "icon": "Segment",
      "type": "page",
      "items": [
        {
          "icon": "ChevronRight",
          "type": "page",
          "items": [
            {
              "icon": "ChevronRight",
              "type": "page",
              "items": [
                {
                  "icon": "ChevronRight",
                  "type": "page",
                  "title": {
                    "__": "Ebene 1.1.1",
                    "en": "Level 1.1.1"
                  }
                }
              ],
              "title": {
                "__": "Ebene 1.1",
                "en": "Level 1.1"
              }
            }
          ],
          "title": {
            "__": "Ebene 1",
            "en": "Level 1"
          }
        }
      ],
      "title": {
        "__": "Seitenstruktur",
        "en": "Structured Pages"
      }
    }
  ],
  "title": "Demo Form",
  "description": "An example ui schema"
}"""
