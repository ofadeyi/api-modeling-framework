# API Modeling Framework

This project aims to provide a common programming interface that lets developers interact with any API specification, whether it is written in OAS or RAML, in a similar way to how the HTML DOM allows programmatic interaction with an HTML document. 

MuleSoft provides a [playground website](https://mulesoft-labs.github.io/amf-playground/app/) for everyone to preview and play with the API Modeling Framework and its capabilities like interoperability, introspection, and more.

## Vision

The API Modeling Framework (AMF) allows users to formally describe different kind of APIs, parse and generate instances of those APIS as sets of modular documents and to store those connected descriptions into a single unified data graph.

![Overview](https://raml-org.github.io/api-modeling-framework/images/diagram.png)

## Status

AMF is alpha and under active development. There are [known gaps](https://github.com/raml-org/api-modeling-framework#implementation-progress) documented on the AMF Github repo.

No artifacts have been pushed yet to any repository but the current version of the library can be built from the source code in this project.
Changes to the current interfaces and vocabularies are to be expected, as well as a possible split of the library into smaller units.

## Concepts

### Parsing and Generation

AMF can be used as a tool to parse RAML and OpenAPI documents, generating a common data model stored in a data graph as the output.

![Translation](https://raml-org.github.io/api-modeling-framework/images/translation.png)

This model can be queried and manipulated, and then serialised back into documents using RAML or OpenAPI syntaxes.
Additional syntaxes like JSON-LD are also supported by the library.

### Interoperability

API information in the AMF model can not only be parsed and generated from RAML and OpenAPI documents, the library also provides functionality for pieces of API description expressed in different syntaxes to work together through the common AMF data model.

### Modularity and Reusability

AMF's data model is modelled after RAML modular features. API descriptions are not monolithic entities confined into a single document. Instead the RAML and AMF conception of APIs is that of a set of reusable behaviours, data types and practises that can be re-used and connected across different APIs in a organisation.

![Composition](https://raml-org.github.io/api-modeling-framework/images/composition.png)


AMF supports different kind of reusable units. The sum of all these units conform AMF's Document Model:

- *Documents*: main entry points for an API description, describing the top level API object
- *Fragments*: Small pieces of API description encapsulating a particular data type, or feature that can be re-used in other units
- *Modules*: Libraries of related elements from an API with identifiers that can referenced in other units

These units can be connected by relationships of inclusion and extension to build aggregate or adapt descriptions

![Document Model](https://raml-org.github.io/api-modeling-framework/images/document_model.png)

### Linked Descriptions

API modular units in the Document Model are connected through hyperlinks. The form a graph of documents that can be explored, easily versioned and exposed using standard HTTP technology. The Web is the native API for AMF.

### Extensible APIs

Units in the Document Model can encode descriptions of APIs for different domains as sets of extensible vocabularies.

RAML annotations and OpenAPI patterned objects are examples of how extensibility is an important feature of an API model, no matter how complete it is, users will need to adapt and extend it.
In fact, RAML and OpenAPIs can be regarded as a collection of vocabularies to describe different domain: HTTP RPC APIs, authentication mechanisms and data shapes.

AMF boost these capacities through the notion of an [extensible Domain Model](https://raml-org.github.io/api-modeling-framework/vocabularies.html).

![Domain Model](https://raml-org.github.io/api-modeling-framework/images/domain_model.png)

New vocabularies can be defined and connected, at the same time, with the existing ones, re-using components already defined.
Eventually AMF will provide tools to easily define this extensions and generate parsers and generators for them.

### Unified Data Graph

Linked API descriptions in the Domain Model split into units in the Document Mode can be combined by the AMF into a single data graph using the resolution algorithm. Pieces of API description from different documents are put together into a single local graph that contains a functional description of the API, composed only of Domain Model elements.
The information into this local data graph can be used by clients, like HTTP clients that just need to consume a API endpoint without caring about the set of linked documents the description of that API is broken into.

### Unified Data Validation

AMF uses a formal data shape validation language in the model to provide validation services for the data conforming to the described APIs. RAML Types and JSON Schemas are translated into these formal constraint language and can be used to validate JSON-like data structures. Data constraints can also be exported as RAML Types or JSON Schema documents, as part of the syntax generation capabilities of the framework.

### Formal Definition and Standards

AMF provide a formal way of describing the vocabularies in the Domain Model, using W3C standards like OWL and RDF Schema. Using formal description tools allow us to reduce the ambiguity in the description of APIs and opens the door to interesting applications like logical inference.
Other W3C standards like RDF as the logical model for the hypermedia data graph of linked APIs or SHACL for data and constraint validation are also used. Using standards allows us not to reinvent the wheel but to build on top of well understood technologies with broad support across languages and platforms.

## Architecture

![Architectural diagram](https://raml-org.github.io/api-modeling-framework/images/arch.png)

The current architecture relies on a collection of parsers and generators for RAML, OpenAPI and JSON-LD (native RDF serialisation). These parsers follow the linked API descriptions in the document model and generate RDF graph data according to the semantics of the HTTP/RPC and data shapes vocabularies.

The resolution service can then be used to combine the information from all these documents in the graph into a single Domain Model resolved graph.
Any subset of the original or resolved graph can be exported back as RAML, OpenAPI or JSON-LD syntaxes.

## Vocabularies

The OWL ontology for the AMF vocabularies (document and domain models) [can be found here](https://github.com/raml-org/api-modeling-framework/blob/master/vocabulary/raml.ttl).
Reference documentation for the ontology can be found [here](https://raml-org.github.io/api-modeling-framework/vocabularies.html).

## Contribution

We welcome any type of contribution; raising bugs or directly providing feedback. For that, please visit the official [AMF Github repository](https://github.com/raml-org/api-modeling-framework). Here you also find additional information like on how to [build](https://github.com/raml-org/api-modeling-framework#installation) the different artifacts provided by AMF. 