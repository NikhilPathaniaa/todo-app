<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body
    {
        height: 90vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    form
    {
        height: 100px;
        width: 300px;
        
    }
    input
    {
        width: 90%;
    }
    button
    {
        margin-top: 20px;
        margin-left: 30px;
    }
</style>
</head>
<body>
    <form action="edit-task" method="post">
    <input type="hidden" name="id" value=<%id %>>
        <fieldset>
            <legend>Edit Task Here,</legend>
            Task Name: <input type="text" name="tname">
            Task description : <input type="text" name="tdescription">
            <button>Edit Task</button>
            <button>Logout</button> 
        </fieldset>
    </form>
</body>
</html>