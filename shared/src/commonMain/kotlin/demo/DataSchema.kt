package demo

//language=JSON
val DATA_SCHEMA = """{
  "id": "b4eed063-bf1b-43d3-8341-e644f5ee8588",
  "type": "dataSchema",
  "title": "Demo Data",
  "properties": {
    "list": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "sum": {
            "type": "number",
            "default": "(num1 + num2) * EnumValue('factor', factor)"
          },
          "num1": {
            "type": "number",
            "default": 0
          },
          "num2": {
            "type": "number",
            "default": 0
          },
          "factor": {
            "enum": [
              "x1",
              "x2",
              "x3",
              "x4"
            ],
            "type": "string",
            "default": "x1",
            "enumValues": [
              1,
              2,
              3,
              4
            ]
          },
          "sumText": {
            "type": "string",
            "default": {
              "__": "Unit sum <%= num1 + num2 %> - Total sum: <%= sum %>",
              "en": "Einzelsumme <%= num1 + num2 %> - Gesamt: <%= sum %>"
            }
          }
        }
      }
    },
    "text": {
      "type": "object",
      "properties": {
        "text1": {
          "type": "string",
          "default": ""
        },
        "text2": {
          "type": "string",
          "default": ""
        },
        "text3": {
          "type": "string",
          "default": ""
        },
        "nested": {
          "type": "object",
          "properties": {
            "nestedText": {
              "type": "string",
              "default": ""
            }
          }
        },
        "textDefault": {
          "type": "string",
          "default": {
            "_": "A place for your text",
            "de": "Hier könnte Ihr Text stehen"
          }
        }
      }
    },
    "total": {
      "type": "number",
      "default": "Sum(ListValues(list, 'sum'))"
    },
    "numbers": {
      "type": "object",
      "properties": {
        "number": {
          "type": "number"
        },
        "integer": {
          "type": "integer"
        },
        "integerExpression": {
          "type": "integer",
          "default": "numbers.integer ^ 2"
        },
        "integerWithDefault": {
          "type": "integer",
          "default": 123
        }
      }
    },
    "options": {
      "type": "object",
      "properties": {
        "bool1": {
          "type": "boolean",
          "default": false
        },
        "bool2": {
          "type": "boolean",
          "default": false
        },
        "enum1": {
          "enum": [
            1,
            2,
            3,
            4
          ],
          "type": "integer"
        },
        "enum2": {
          "enum": [
            1,
            2,
            3,
            4
          ],
          "type": "integer"
        }
      }
    },
    "properties": {
      "type": "object",
      "properties": {
        "text": {
          "type": "string"
        },
        "enabled": {
          "type": "boolean",
          "default": true
        },
        "visible": {
          "type": "boolean",
          "default": true
        },
        "required": {
          "type": "boolean",
          "default": true
        }
      }
    },
    "dateAndTime": {
      "type": "object",
      "properties": {
        "date": {
          "type": "string",
          "format": "date"
        },
        "time": {
          "type": "string",
          "format": "time"
        },
        "dateTime": {
          "type": "string",
          "format": "date-time"
        }
      }
    },
    "calculations": {
      "type": "object",
      "properties": {
        "x": {
          "type": "number"
        },
        "y": {
          "type": "number"
        }
      }
    }
  },
  "description": "Demo data schema"
}"""
