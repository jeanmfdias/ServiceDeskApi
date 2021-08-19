const express = require('express');

const app = express();

app.listen(3000, () => console.log('server runnig at 3000 port'));

app.get('/calls',  (req, res) => {
    res.send('you are calls route');
});