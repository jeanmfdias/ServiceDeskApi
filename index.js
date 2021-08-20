const customExpress = require('./config/custom_express');

const app = customExpress();

app.listen(3000, () => console.log('server runnig at 3000 port'));
