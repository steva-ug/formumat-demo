package demo

//language=JSON
val DATA_SCHEMA = """{
  "type": "dataSchema",
  "id": "b4eed063-bf1b-43d3-8341-e644f5ee8588",
  "title": "Demo Data",
  "description": "Demo data schema",
  "properties": {
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
          "type": "integer",
          "enum": [1, 2, 3, 4]
        },
        "enum2": {
          "type": "integer",
          "enum": [1, 2, 3, 4]
        }
      }  
    },
    "numbers": {
      "type": "object",
      "properties": {
        "integer": {
          "type": "integer",
          "default": 0
        },
        "number": {
          "type": "number"
        },
        "integerExpression": {
          "type": "integer",
          "default": "numbers.integer ^ 2"
        }
      }
    },
    "dateAndTime": {
      "type": "object",
      "properties": {
        "dateTime": {
          "type": "string",
          "format": "date-time"
        },
        "date": {
          "type": "string",
          "format": "date"
        },
        "time": {
          "type": "string",
          "format": "time"
        }
      }
    },
    "list": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "num1": {
            "type": "number",
            "default": 0.0
          },
          "num2": {
            "type": "number",
            "default": 0.0
          },
          "factor": {
            "type": "string",
            "default": "x1",
            "enum": ["x1", "x2", "x3", "x4"],
            "enumValues": [1, 2, 3, 4]
          },
          "sum": {
            "type": "number",
            "default": "{{ (num1 + num2) * EnumValue('factor', factor)}}"
          }
        }
      }
    },
    "total": {
      "type": "number",
      "default": "Sum(ListValues(list, 'sum'))"
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
    }
  }
}
"""
