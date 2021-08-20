module.exports = app => {
    app.get('/calls',  (req, res) => {
        res.send('you are calls route');
    });    
}