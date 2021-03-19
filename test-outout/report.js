$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/resources/CrudOperations.feature");
formatter.feature({
  "name": "CRUD operations for REST API",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "creating employee records successfully",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "user sends the below details for creating the contanct",
  "keyword": "Given ",
  "rows": [
    {
      "cells": [
        "firstName",
        "\u003cfirstName\u003e"
      ]
    },
    {
      "cells": [
        "secondName",
        "\u003csecondName"
      ]
    },
    {
      "cells": [
        "designation",
        "\u003cdesignation\u003e"
      ]
    },
    {
      "cells": [
        "salary",
        "\u003csalary\u003e"
      ]
    }
  ]
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "firstName",
        "secondName",
        "designation",
        "salary"
      ]
    },
    {
      "cells": [
        "John",
        "Johnson",
        "Associate",
        "10000"
      ]
    }
  ]
});
formatter.scenario({
  "name": "creating employee records successfully",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "user sends the below details for creating the contanct",
  "rows": [
    {
      "cells": [
        "firstName",
        "John"
      ]
    },
    {
      "cells": [
        "secondName",
        "\u003csecondName"
      ]
    },
    {
      "cells": [
        "designation",
        "Associate"
      ]
    },
    {
      "cells": [
        "salary",
        "10000"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});