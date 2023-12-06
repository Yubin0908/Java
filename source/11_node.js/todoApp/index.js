const express = require('express'); // express library 첨부선언
const app = express(); // express를 이용하여 객체 생성
const url = "mongodb+srv://yubin:yubin@yubin.wwatfan.mongodb.net/?retryWrites=true&w=majority";

const MongoClient = require('mongodb').MongoClient;
var db;
MongoClient.connect(url, (err, client) => {
  // db 연결 후 실행할 콜백함수
  if(err) return console.log(err);
  db = client.db('todoApp');
  // _fieldName = primaryKey
/*  db.collection('post').insertOne({이름:'홍길동', 나이:10}, (err, result) => {
    if(err) return console.log(err);
    console.log('1번 저장');
  }); */ // insert 로직
  // app.listen(port, function)
  app.listen(8090, () => console.log('listening on 8090'));
});// db 연결함수

// app.get(url, function)
// app.post(url, function)
// app.put(url, function)
// app.delete(url, function)
app.get('/pet', (req, res) => res.send('<h2>펫 용품 쇼핑 페이지입니다.</h2>'));
app.set('view engine', 'ejs');
app.use(express.static('public')); // css, js 폴더
app.get('/', (req, res) => res.render('index.ejs')); // '/'요청경로 시, index.html 실행 res.sendFile(__dirname + '/index.html')
app.get('/write', (req, res) => res.render('write.ejs'));
app.use(express.urlencoded({extended:true})); // parameter 접근

app.post('/write', (req, res) => {
  
  //  1. seq에서 post_sq를 가져옴
  db.collection('seq').findOne({name: '현재시퀀스'}, (err, result) => {
    if(err) return console.log(err);
    var post_sq = result.post_sq;
    //  2. {_id:post_sq+1, title:req.body.tltle, date:req.body.date} 를 post에 insert
    db.collection('post').insertOne({_id: post_sq+1, title: req.body.title, date: req.body.date}, (err, result) => {
      if(err) return console.log(err);
      //  3. seq의 post_sq 1증가 updateOne({조건}, {수정할 내용}, 콜백함수) 사용
      //                         updateOne({조건}, {$inc: {증가분}}, 콜백함수) 사용
      //                         updateOne({조건}, {$set: {수정내용}}, 콜백함수) 사용
      db.collection('seq').updateOne({name:'현재시퀀스'}, {$set : { post_sq : post_sq+1}}, (err, result) => {
        if(err) return console.log(err);
        res.redirect('/list');
      });
    });
  });
  
  /* db.collection('post').insertOne(req.body, (err, result) => {
    if(err) return console.log(err);
    console.log('등록완료');
    res.redirect('/list');
  }); */
  // mongoDB Insert
});

app.get('/list', (req, res) => {
  // post에서 저장된 데이터(배열)로 view단 출력(ejs)
  db.collection('post').find().toArray((err, result) => {
    if(err) return console.log(err);
    res.render('list.ejs', {posts:result});
  });
});