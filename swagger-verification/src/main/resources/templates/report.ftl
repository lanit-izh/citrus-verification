<#ftl output_format="HTML">
    <#import "generation.ftl" as generation />

<html>
        <head>
            <title>IncorrectEndpoints</title>
script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
            integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
            <script src="https://kit.fontawesome.com/0b83173bdb.js" crossorigin="anonymous"></script>
            <style>
                .title {
                    margin - top: 60px;
        }

        .progress {
                    position: relative;
        }

        .progress span {
                    position: absolute;
            display: block;
            width: 100%;
            color: black;
        }
    </style>
    </head>
        <body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <a class="navbar-brand" href="#">Report</a>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#summary-section">Summary</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#details-section">Operations details</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#tag-section">Tags details</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#condition-section">Conditions details</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#system-section">Generation info</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

 <section id="details-section">
            <div class="row">
                <div class="col-12">
                    <h2 class="title" id="details">Operations</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <ul class="nav nav-pills nav-fill" id="detail-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="condition-tab" data-toggle="tab" href="#condition" role="tab"
                               aria-controls="condition" aria-selected="true">
                               Operations :Operations}
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="full-tab" data-toggle="tab" href="#full" role="tab"
                               aria-controls="full" aria-selected="true">
                               Operations: Operations
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="party-tab" data-toggle="tab" href="#party" role="tab"
                               aria-controls="party" aria-selected="true">
                                Operations: Operations
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="empty-tab" data-toggle="tab" href="#empty" role="tab"
                               aria-controls="empty" aria-selected="true">
                            Operations: Operations
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="zero-tab" data-toggle="tab" href="#zero" role="tab"
                               aria-controls="zero" aria-selected="true">
                                Operations:Operations
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="missed-tab" data-toggle="tab" href="#missed" role="tab"
                               aria-controls="missed" aria-selected="false">
                               Operations: Operations
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-12">
                    <div class="tab-content" id="details-content">
                        <div class="tab-pane fade show active" id="condition" role="tabpanel" aria-labelledby="condition-tab">
                            <Operations"/>
                        </div>
                        <div class="tab-pane fade" id="full" role="tabpanel" aria-labelledby="full-tab">
                            <Operations prefix="full"/>
                        </div>
                        <div class="tab-pane fade" id="party" role="tabpanel" aria-labelledby="party-tab">
                            <Operations prefix="party"/>
                        </div>
                        <div class="tab-pane fade" id="empty" role="tabpanel" aria-labelledby="empty-tab">
                            <Operations prefix="empty"/>
                        </div>
                        <div class="tab-pane fade" id="zero" role="tabpanel" aria-labelledby="zero-tab">
                            <Operationsprefix="zero"/>
                        </div>
                        <div class="tab-pane fade" id="missed" role="tabpanel" aria-labelledby="missed-tab">
                            <Operationsprefix="missed"/>
                        </div>
                    </div>
                </div>
            </div>
        </section>

          <section id="condition-section">
                    <div class="row">
                        <div class="col-12">
                            <h2 class="title" id="conditions">Operation</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="accordion col-12" id="conditions-by-type-accordion">
                            <#list results.getGetIncorrectEndpoints()  as key>
                                <div class="card">
                                    <div class="card-header">
                                        <div class="row"
                                             data-toggle="collapse"
                                             data-target="#conditions-by-type-Operation"
                                             aria-expanded="true"
                                             aria-controls="collapseOne">
                                            <div class="col-8">
                                                <#assign nameKey = "Operation">
                                                <#assign descriptionKey = "Operation">
                                                <p><strong>nameKey</strong></p>
                                                <small>descriptionKey</small>
                                            </div>
                                            <div class="col-4">
                                                <descriptionKey
                                                    full=descriptionKey
                                                    current=descriptionKey
                                                    postfix=Operation
                                                />
                                            </div>
                                        </div>
                                    </div>
                                    <div id="conditions-by-type-${key?index}" class="collapse" aria-labelledby="headingOne">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-12">
                                                    <ul class="nav nav-pills nav-fill" id="condition-tabs-${key?index}" role="tablist">
                                                        <li class="nav-item">
                                                            <a class="nav-link active" id="tab-condition-covered-${key?index}" data-toggle="tab" href="#condition-covered-${key?index}" role="tab"
                                                               aria-controls="condition-covered-${key?index}" aria-selected="true">
                                                                {i18["summary.conditions.covered"]}: {value.coveredOperation?size}
                                                            </a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" id="tab-condition-uncovered-${key?index}" data-toggle="tab" href="#condition-uncovered-${key?index}" role="tab"
                                                               aria-controls="condition-uncovered-${key?index}" aria-selected="true">
                                                                {i18["summary.conditions.uncovered"]}: {value.uncoveredOperation?size}
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-12">
                                                    <div class="tab-content" id="details-content-${key?index}">
                                                        <div class="tab-pane fade show active" id="condition-covered-${key?index}" role="tabpanel" aria-labelledby="tab-condition-covered-${key?index}">
                                                            <table class="table table-sm">
                                                                <thead>
                                                                <tr>
                                                                    <th scope="col">{i18["details.condition.operation"]}</th>
                                                                    <th scope="col">{i18["details.condition.conditionname"]}e</th>
                                                                    <th scope="col">{i18["details.condition.details"]}</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <#list results.getGetIncorrectEndpoints()  as conditionItem>
                                                                    <tr class="table-success">
                                                                        <td>
                                                                            <span>
                                                                                <i class="fas fa-check"></i>
                                                                            </span>
                                                                            &nbsp;{conditionItem.operation}
                                                                        </td>
                                                                        <td>{conditionItem.condition.name}</td>
                                                                        <td>{conditionItem.condition.reason?no_esc}</td>
                                                                    </tr>
                                                                </#list>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <div class="tab-pane fade" id="condition-uncovered-${key?index}" role="tabpanel" aria-labelledby="tab-condition-uncovered-${key?index}">
                                                            <table class="table table-sm">
                                                                <thead>
                                                                <tr>
                                                                    <th scope="col">{i18["details.condition.operation"]}</th>
                                                                    <th scope="col">{i18["details.condition.conditionname"]}e</th>
                                                                    <th scope="col">{i18["details.condition.details"]}</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <#list results.getGetIncorrectEndpoints() as conditionItem>
                                                                    <tr class="table-danger">
                                                                        <td>
                                                                            <span>
                                                                                <i class="fas fa-bug"></i>
                                                                            </span>
                                                                            &nbsp;{conditionItem.operation}
                                                                        </td>
                                                                        <td>{conditionItem.condition.name}</td>
                                                                        <td>{conditionItem.condition.reason?no_esc}</td>
                                                                    </tr>
                                                                </#list>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </div>
                    </div>
                </section>
<br>
            <h1>GET INCORRECT ENDPOINTS</h1>

            <ul>
                <#list results.getGetIncorrectEndpoints() as item>

                <li>${item.getKey()}</li>
                <#else>
                    <p>All endpoints are correct
            </#list>
</ul>
                <#list results.getGetIncorrectEndpoints() as item>

<form:form method="POST" commandName="customerForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>

			<tr>
				<td>Country :</td>
				<td><form:select path="${item.getKey()}">
					  <form:option value="NONE" label="--- Select ---" />
					  <form:options items="${item.getKey()}" />
				       </form:select>
                                </td>
				<td><form:errors path="${item.getKey()}" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Java Skills :</td>
				<td><form:select path="${item.getKey()}" items="${item.getKey()}"
					multiple="true" /></td>
				<td><form:errors path="${item.getKey()}" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
            </#list>


                <h1>POST INCORRECT ENDPOINTS</h1>
                <nav role="navigation">
                    <ul>
                        <#list results.getPostIncorrectEndpoints() as item>
           <li>${item.getKey()}</li>
                        <#else>
                            <p>All endpoints are correct
       </#list>
   </ul>
</nav>
                    <h1>PUT INCORRECT ENDPOINTS</h1>
                    <ul>
                        <#list results.getPutIncorrectEndpoints() as item>
           <li>${item.getKey()}</li>
                        <#else>
                            <p>All endpoints are correct
       </#list>
   </ul>

                        <h1>DELETE INCORRECT ENDPOINTS</h1>
                        <ul>
                            <#list results.getDeleteIncorrectEndpoints() as item>
              <li>${item.getKey()}</li>
                            <#else>
                                <p>All endpoints are correct
          </#list>
      </ul>

</body >
</html >