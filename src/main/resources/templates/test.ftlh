<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Test Page</title>
</head>
<body>
<section class="section">
    <#list files as file>
        <p>${file.getName()}</p>
    </#list>
</section>
</body>
</html>