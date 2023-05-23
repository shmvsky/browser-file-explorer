<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <title>${meta.title}</title>
</head>
<body>
    <section class="section">
        <h1 class="title">${meta.title}</h1>
        <p class="subtitle">${meta.description}</p>
    </section>

    <section class="section pt-0">
        <nav class="breadcrumb">
            <ul>
                <li><a href="/file-explorer?dir=${content.baseDirectory.getPath()}">$</a></li>
                <#list content.breadCrumb as e>
                    <li><a href="/file-explorer?dir=${e.getPath()}">${e.getName()}</a></li>
                </#list>
            </ul>
        </nav>
        <div class="">
            <div class="tag is-size-6 mr-4 mb-4">
                    <span class="icon material-symbols-outlined">folder</span>
                <a class="is-link" href="/file-explorer?dir=${content.getParentDirectory().getPath()}">..</a>
            </div>
            <#list content.files as file>
                <div class="tag is-size-6 mr-4 mb-4">
                    <span class="icon material-symbols-outlined">
                        <#if file.isFile()>draft<#else>folder</#if>
                    </span>
                    <a class="is-link" href="/file-explorer?dir=${file.getPath()}">${file.getName()}</a>
                </div>
            </#list>
        </div>
    </section>
</body>
</html>