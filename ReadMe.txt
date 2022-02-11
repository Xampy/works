[
  {
    "url": "/api/v1/proprietaires",
    "method": "POST",
    "headers": [],
    "params": [],
    "bodyJson": "{
        "id": 0,
        "nom": string,
        "telephone": string,
        "adresse": string,
        "email": string
    }",
    "description": "Création d'un propriétaire",
    "moduleName": "rest-patrimo-api"
  },
  {
    "url": "/api/v1/proprietaires/{id}",
    "method": "PUT",
    "headers": [],
    "params": [
      {
        "key": "id",
        "type": "number"
      }
    ],
    "bodyJson": {
        "id": number,
        "nom": string,
        "telephone": string,
        "adresse": string,
        "email": string
    },
    "description": "Mettre à jour un propriétaire",
    "moduleName": "rest-patrimo-api"
  },
  {
    "url": "/api/v1/proprietaires/{id}",
    "method": "GET",
    "headers": [],
    "params": [
      {
        "key": "id",
        "type": "string"
      }
    ],
    "bodyJson": null,
    "description": "Récupérer un propriétaire par son ID",
    "moduleName": "rest-patrimo-api"
  },
  {
    "url": "/api/v1/proprietaires",
    "method": "GET",
    "headers": [],
    "params": [],
    "bodyJson": Array<bodyJson of "/api/v1/proprietaires/{id}">,
    "description": "Récupérer la liste de tous les propriétaires",
    "moduleName": "rest-patrimo-api"
  },
  {
    "url": "/api/v1/proprietaires/{id}",
    "method": "DELETE",
    "headers": [],
    "params": [
      {
        "key": "id",
        "type": "string"
      }
    ],
    "bodyJson": "",
    "description": "Supprimer un propriétaire par son id",
    "moduleName": "rest-patrimo-api",
  },
  {
    "url": "/api/v1/proprietaires/{proprietaireId}/patrimoine/{patrimoineId}",
    "method": "POST",
    "headers": [],
    "params": [
      {
        "key": "proprietaireId",
        "type": "number",
        "description": "L'id du propriétaire à qui va appartenir le patrimoine"
      },
      {
        "key": "patrimoineId",
        "type": "number",
        "description": "l'id du patrimoine"
      }
    ],
    "bodyJson": null,
    "description": "Ajout d'un patrimoine à la liste des patrimoines d'un propriétaire",
    "moduleName": "rest-patrimo-api",
  },
  {
    "url": "/api/v1/proprietaires/{proprietaireId}/patrimoine/{patrimoineId}",
    "method": "DELETE",
    "headers": [],
    "params": [
      {
        "key": "proprietaireId",
        "type": "number",
        "description": "L'id du propriétaire à qui va appartenir le patrimoine"
      },
      {
        "key": "patrimoineId",
        "type": number,
        "description": "l'id du patrimoine"
      }
    ],
    "bodyJson": "",
    "description": "Retarait d'un patrimoine de la liste des patrimoines d'un propriétaire",
    "moduleName": "rest-patrimo-api"
  },
  {
    "url": "/api/v1/patrimoines",
    "method": "POST",
    "headers": [],
    "params": [],
    "bodyJson": {
        "id": number,
        "code": string,
        "nom": string,
        "etat": string,
        "longitude": number,
        "latitude": number,
        "adresse": strong,
        "proprietaires\": [],
        "sousPatrimoines\": [],
    },
    "description": "Enrégistrer un patrimoine",
    "moduleName": "rest-patrimo-api",
  },
  {
    "url": "/api/v1/patrimoines/{id}/_sousPatrimoine/{sid}",
    "method": "POST",
    "headers": [],
    "params": [
      {
        "key": "id",
        "type": "number",
        "description": "L'id du patrimoine parent"
      },
      {
        "key": "sid",
        "type": "number",
        "description": "L'id du patrimoine qui va être ajouté en tant que sous patrimoine du patrimoine parent"
      }
    ],
    "bodyJson": null,
    "description": Ajouter un sous patrimoine à un patrimoine,
    "moduleName": "rest-patrimo-api",
  },
  {
    "url": "/api/v1/patrimoines/{id}",
    "method": "PUT",
    "headers": [],
    "params": [
      {
        "key": "id",
        "type": "number"
      }
    ],
    "bodyJson": bodyJson of ["url": "/api/v1/patrimoines", "method": "POST"]
    "description": "Mettre à jour les informations d'un patrimoine",
    }
    "moduleName": "rest-patrimo-api"
  },
  {
    "url": "/api/v1/patrimoines/{id}",
    "method": "GET",
    "headers": [],
    "params": [
      {
        "key": "id",
        "type": "number"
      }
    ],
    "bodyJson": bodyJson of ["url": "/api/v1/patrimoines", "method": "POST"],
    "description": "Récupérer un patrimoine par son id",
    "moduleName": "rest-patrimo-api",
  },
  {
    "url": "/api/v1/patrimoines",
    "method": "GET",
    "headers": [],
    "params": [],
    "bodyJson": Array<bodyJson of ["url": "/api/v1/patrimoines", "method": "POST"]>,
    "description": "Récupérer la liste des patrimoines",
    "moduleName": "rest-patrimo-api",
  },
  {
    "url": "/api/v1/patrimoines/{id}",
    "method": "DELETE",
    "headers": [],
    "params": [
      {
        "key": "id",
        "type": "number"
      }
    ],
    "bodyJson": null,
    "description": "Suprrimer un patrimoine",
    "moduleName": "rest-patrimo-api"
  },
  {
    "url": "/api/v1/patrimoines/_no_proprietaire",
    "method": "GET",
    "headers": [],
    "params": [],
    "bodyJson": Array<bodyJson of ["url": "/api/v1/patrimoines", "method": "POST"]>,
    "description": "Récupérer la liste des patrimoines dont on ne connait pas les propriétaires",
    "moduleName": "rest-patrimo-api",
  },
  {
    "url": "/api/v1/patrimoines/{id}/_sousPatrimoines",
    "method": "GET",
    "headers": [],
    "params": [
      {
        "key": "id",
        "type": "number"
      }
    ],
    "bodyJson": Array<bodyJson of ["url": "/api/v1/patrimoines/", "method": "POST"]>,
    "description": "Réccuperer la liste des patrimoines contenus dans un patrimoine",
    "moduleName": "rest-patrimo-api"
  }
]