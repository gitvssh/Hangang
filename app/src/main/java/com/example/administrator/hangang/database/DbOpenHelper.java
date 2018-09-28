package com.example.administrator.hangang.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper {


    private static final String DATABASE_NAME = "hangang.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    //SQLite헬퍼클래스 상속 내부클래스, db관리용(생성,오픈,조회)
    private class DatabaseHelper extends SQLiteOpenHelper {

        //생성자
        public DatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        //DB가 존재하지 않을때 최초 1회 호출하여 DB생성
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBase.CreateDB.CREATE);
            //TODO : 최초생성시 프로그램 정보 입력SQL 여기다 넣어야함

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('1', '한강수상놀이터'," +
                    " '카약, 카누, 패들보드, 수상자전거, 오리보트', '7.20(금)~8.19(일) 10:00~22:00(무동력은 19:00까지)', " +
                    "'여의도한강공원 파라다이스 인근 수상', '현장접수, 사전예약', " +
                    "'1만원~3만원(일부프로그램 초보강습비 별도, 프로그램 내용 참조)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('2', '한강물싸움축제', " +
                    "'한강몽땅 대표 프로그램으로 더위를 시원하게 날려버리는 물싸움 대전', '8.4(토)~8.5(일) 11:00~18:00'," +
                    "'난지한강공원 젊음의광장', '사전예약, 현장접수', '1만1천원 (7세 이하 무료입장)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('3', '한강몽땅 종이배경주대회', " +
                    "'직접 만든 종이배를 타고 한강 위의 반환점을 돌아오는 경주대회', '8.10(금)~8.12(일) 09:00~16:30'," +
                    "'잠실한강공원 내 잠실나들목 앞 둔치', '사전예약, 현장접수', '50,000원jjj(배 1대 제작 기준)');");
            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('4', '한강자전거한바퀴'," +
                "'한강의 대자연을 체험할 수 있는 자전거 축제', '8.15(수) 08:00~14:00', " +
                "'여의도한강공원 이벤트광장', '모바일앱 사전예약(자전거네비게이션 오픈라이더 모바일앱)', " +
                "'1만원');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('5', '2018 한강크로스스위밍챌린지'," +
                    "'한강은 자동차로만 건너는 게 아냐!', '8.19(일)  09:00~17:00', " +
                    "'잠실한강 잠실대교 남단 수중보 인근', '참가신청서 접수 : : http://cafe.daum.net/spgswim의 대회 공지게시판 참조', " +
                    "'40,000원');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('6', '한강파이어댄싱페스티벌'," +
                    "'세계 정상 급 파이어 댄서들과 불꽃놀이', '7.28(토)~29(일) / 19:00~22:00', " +
                    "'반포 한강공원 예빛무대 일대', '현장참여', " +
                    "'무료');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('7', '한강달빛서커스'," +
                    "'전통에서 컨템포러리까지 시대를 아우르는 서커스공연', '8.3(금)~8.5(일) 18:00~22:00', " +
                    "'반포한강공원 세빛섬 앞', '현장관람 및 체험', " +
                    "'무료');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('8', '한여름밤의 재즈'," +
                    "'한강으로 소풍 나온 재즈', '8.14(화)~8.15(수) 18:00~22:00', " +
                    "'반포한강공원 세빛섬 앞 피크닉장', '자유관람', " +
                    "'무료');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('9', '한강다리밑영화제'," +
                    "'한여름 밤에 즐기는 이색 영화관', '7. 21(토)~8.18(토) 매주 토요일 20~22:00', " +
                    "'망원 서울함 공원, 여의도 원효대교 남단 하부, 뚝섬 청담대교 북단 하부, 광나루 천호대교 남단 하부', '현장 자율 참여', " +
                    "'없음');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('10', '다리밑헌책방축제'," +
                    "'한강 다리밑에서 만나는 도심 속 최대 규모의 헌책방 장터', '8.1(수) ~ 8.15(수) / 11:00~22:00', " +
                    "'여의도 한강공원 마포대교 하부', '사전 예약 및 현장 참여', " +
                    "'무료');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('11', '한강별빛소극장'," +
                    "'다양한 공연, 전시, 놀이체험, 쉼터 등 한강몽땅 최고의 가족콘텐츠', '8.10(금)~8.12(일) 15:00~22:00', " +
                    "'여의도한강공원이벤트 광장 일대', '자유관람 및 체험', " +
                    "'무료');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('12', '한강나이트워크42K'," +
                    "'달빛과 함께 출발하여 여명과 함께 도착하는 한강 밤샘걷기', '7. 28(토) /16:00~익일 07:00', " +
                    "'여의도 한강공원 녹음수 광장(출발지) 및 한강일대', '공식 홈페이지 사전 접수', " +
                    "'42K 40,000원 25K 35,000원 15K 30,000원 (1인 기준)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('13', '한강여름생태학교'," +
                    "'한강에서 자연과 함께 피서하고, 더위를 몽땅 날려버리자!', '7.20(금)~8.19(일) / 10:00~21:30', " +
                    "'- 직영공원 : 여의도샛강안내센터 1층, 강서안내센터3층, 이촌자연학습장(잠원, 잠실, 이촌),\n" +
                    "뚝섬자벌레1층\n" +
                    "- 민간위탁공원 : 고덕수변생태공원, 난지생태습지원, 한강야생탐사센터, 암사생태공원\n', '서울시공공예약시스템 사전예약', " +
                    "'무료');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('14', '한강여름캠핑장'," +
                    "'도심 한강변에서 즐기는 한여름 밤의 추억', '7.13(금)~8.26(일) 15:00~익일 11:00(1박2일)', " +
                    "'2개공원 텐트280동(여의도한강공원150동, 뚝섬한강공원130동)', '사전예약', " +
                    "'- 주말(금,토,일), 공휴일 : 25,000원\n" +
                    "- 평일(월,화,수,목) : 15,000원\n" +
                    "  (캠핑용품 대여료 별도)\n');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('15', '한강데이트'," +
                    "'한강 최고의 야경과 강바람, 그리고 잔잔한 음악', '7.28(토)~8.11(토) 매주 토 및 8.19(일) 19:00~22:00', " +
                    "'한강 야경명소 4곳(반포,양화, 뚝섬, 여의도 한강공원 순)', '현장참여, 사전예약', " +
                    "'무료');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('16', '서울밤도깨비야시장@한강'," +
                    "'한여름 밤, 한강에서 볼거리, 먹거리 즐길거리가 한자리에 펼쳐진다', '7.20(금) ~ 8.19.(일)  매주 금 18:00 ~ 23:00, 토 17:00~23:00', " +
                    "'여의도 한강공원 물빛광장 및 반포 한강공원 달빛광장 일대', '현장참여', " +
                    "'무료');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('17', 'Hangang Playground'," +
                    "'Kayak, canoe, SUP, water bike, rubber boat', '10:00-22:00, July 20-August 19 (nonpowered boats until 19:00)', " +
                    "'On the river near Paradise, Yeouido', 'On-site participation or reservation', " +
                    "'charged (different fees for each program)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('18', 'Hangang Water Fight Festival'," +
                    "'Water fight with water balloons and guns', '11:00-18:00, August 4-5', " +
                    "'Square of Youth at Nanji Hangang Park', 'On-site participation or reservation', " +
                    "'11,000 won');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('19', 'Hangang Paper Boat Competition'," +
                    "'A competition on the Hangang River riding in paper boats', '09:00-16:30, August 10-12', " +
                    "'From the riverside at Jamsil Hangang Park in front of Jamsil Underpass', 'On-site participation or reservation', " +
                    "'50,000 won (for 1 boat)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('20', 'Hangang Bike Tour'," +
                    "'A tour of the Hangang riverside riding a bicycle', '08:00-14:00, August 15', " +
                    "'From Yeouido Hangang Park', 'Reservation via mobile app Open rider', " +
                    "'10,000 won');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('21', '2018 Hangang Cross Swimming Challenge'," +
                    "'Lets swim across the Hangang River!', '09:00-17:00, August 19', " +
                    "'The dammed pool at the Southern end of Jamsildaegyo Bridge', 'Reservation', " +
                    "'40,000 won');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('22', 'Hangang Fire Dancing Festival'," +
                    "'A performance by the worlds best fire dancing artist and fireworks', '17:00-22:00, July 28-29', " +
                    "'Around the Yebit Stage at Banpo Hangang Park', 'First come first served', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('23', 'Hangang Moonlight Circus'," +
                    "'A circus under the riverside moonlight', '18:00-22:00, August 3-5', " +
                    "'in front of Sebitseom Island at Banpo Hangang Park', 'First come first served', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('24', 'Hangang Jazz Festival with Jarasum Jazz'," +
                    "'Hangang outdoor jazz concert', '18:00-22:00, August 14-15', " +
                    "'The picnic area in front of Sebitseom Island at Banpo Hangang Park', 'First come first served', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('25', 'Hangang Under the Bridge Film Festival'," +
                    "'A unique movie theater for summer nights', '20:00-22:00, July 21-August 18 (every Sat.)', " +
                    "'Lawns around Cheonho (Gwangnaru), Ttukseom (Cheongdam), Yeouido (Wonhyodaegyo Bridge), Mangwon (Seongsandaegyo Bridge)', 'First come first served', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('26', 'Under the Bridge Secondhand Book Festival'," +
                    "'The largest-scale secondhand book market in the city under a Hangang bridge', '11:00-22:00, August 1-15', " +
                    "'Yeouido Hangang Park under the Southern end of Mapodaegyo Bridge', 'On-site participation or reservation', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('27', 'Hangang Starlight Small Theater'," +
                    "'A surprising gift for families on excursions-various performances, exhibitions, and experience programs', '15:00-22:00, August 10-12', " +
                    "'Around the event square at Yeouido Hangang Park', 'First come first served', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('28', 'Hangang Night Walk 42K'," +
                    "'Hangang night walk that starts in the evening and ends in the early morning (three courses: 42km, 25km, 15km)', '16:00-07:00, July 28', " +
                    "'From Nogeumsu Plaza at Yeouido Hangang Park, along Hangang River', 'Reservation', " +
                    "'40,000 won for 42km, 35,000 won for 25km, 30,000 won for 15km');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('29', 'Hangang Summer Green School'," +
                    "'Lets spend the hot summer experiencing nature!', '10:00-21:30, July 20-August 19', " +
                    "'Nanji, Ichon, Jamwon, Ttukseom, Jamsil, Gwangnaru, etc.', 'Reservation', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('30', 'Hangang Summer Campground'," +
                    "'Enjoy the summer night at the citys riverside!', '15:00-11:00, July 13-August 26', " +
                    "'Yeouido and Ttukseom Hangang Park', 'Reservation', " +
                    "'15,000-25,000 won (rental fees for camping supplies not included)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('31', 'Hangang Date'," +
                    "'An intimate time flowing with the Hangang River', '19:00-22:00, July 28-August 11 (every Sat.), and August 19 (Sun.)', " +
                    "'four spots around Hangang River with scenic night views (Banpo, Yanghwa, Ttukseom, Yeouido Hangang Park, etc.)', 'On-site participation', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('32', 'Seoul Bamdokkaebi Night Market @Hangang'," +
                    "'A place offering things to eat, enjoy, and see at the Hangang River on a summer night.', '18:00-23:00, July 20-August 19(18:00-23:00 every Fri., 17:00-23:00 every Sat.)', " +
                    "'Cascade Plaza at Yeouido Hangang Park and Moonlight Square at Banpo Hangang Park', 'On-site participation', " +
                    "'free of charge');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('33', 'ハンガン水上遊び場'," +
                    "'カヤック、カヌー、SUP、水上自転車、ゴムボート', '10:00~22:00 (動力なしの種目は19:00まで)', " +
                    "'ヨイド(汝矣島)パラダイス近隣の水上', '現場受付、事前予約', " +
                    "'有料(プログラムによって異なる)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('34', 'ハンガンウォーターファイト祭り'," +
                    "'水風船と水鉄砲で楽しむウォーターファイト対戦', '8.4(土)~8.5(日) 11:00~18:00', " +
                    "'ナンジ(蘭芝)ハンガン公園 青春広場', '事前予約、現場受付', " +
                    "'1万1千ウォン');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('35', 'ハンガン紙船レース'," +
                    "'ハンガンで繰り広げる紙船レース', '8.10(金)~8.12(日) 09:00~16:30', " +
                    "'チャムシル(蚕室)ハンガン公園内の チャムシル地下通路前の河川敷', '現場受付、事前予約', " +
                    "'5万ウォン(船1艇製作基準)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('36', 'ハンガン自転車一周'," +
                    "'自転車に乗って楽しむ涼しいハンガン(漢江)一周', '8.15(水) 08:00~14:00', " +
                    "'ヨイド(汝矣島)ハンガン公園(スタート地点)', 'モバイルアプリ「open rider」で事前予約', " +
                    "'1万ウォン');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('37', '2018ハンガンクロス・スイミングチャレンジ'," +
                    "'ハンガンを渡ってみよう!', '8.19(日) 09:00~17:00', " +
                    "'ハンガンチャムシル(蚕室)大橋南端の水中状', '事前予約', " +
                    "'4万ウォン');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('38', 'ハンガンファイヤーダンスフェスティバル'," +
                    "'世界トップクラスのファイヤーダンス アーティスト公演と花火祭り', '7.28(土)~7.29(日) 17:00~22:00', " +
                    "'パンポ盤浦)ハンガン公園 イェビッステージ一帯', '現場参加', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('39', 'ハンガン月光サーカス'," +
                    "'月光の下で楽しむサーカス公演', '8.3(金)~8.5(日) 18:00~22:00', " +
                    "'パンポ(盤浦)ハンガン公園セビッ島前', '現場参加', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('40', '真夏の夜のジャズ'," +
                    "'ハンガンにジャズがやってきた!', '8.14(火)~8.15(水) 18:00~22:00', " +
                    "'パンポ(盤浦)ハンガン公園 セビッ島前のピクニック場', '現場觀覽', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('41', 'ハンガン橋の下の映画祭'," +
                    "'真夏の夜に楽しむユニークな映画館', '7.21(土)~8.18(土)、毎週土曜日 20:00~22:00', " +
                    "'クァンナル・チョンホ(千戸)、 トゥクソム・チョンダム清潭、 ヨイド(改実島)ウォンヒョ(元暁)大橋、 マンウォン望遠ソンサン(城山) 大橋周辺の芝生', '現場で自由観覧', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('42', '橋の下の古本祭り'," +
                    "'ハンガンの橋の下で出会う 都心最大の古本市場', '8.1(水)~8.15(水) 11:00~22:00', " +
                    "'ヨイド(改失島)ハンガン公園 マポ(麻浦大橋南端の下', '事前予約、現場参加', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('43', 'ハンガン星光小劇場'," +
                    "'多彩な公演、展示、遊び体験など家族連れ のための総合ギフトセット', '8.10(金)~12(日) 15:00~22:00', " +
                    "'ヨイド(改矣島)ハンガン公園 イベント広場一帯', '現場参加', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('44', 'ハンガンナイトウォーク42K'," +
                    "'月光とともに出発して夜明けとともに到着する ハンガン徹夜ウォーキングイベント (42km/25km/15km、3つのコース)', '7.28(土) 16:00~翌日07:00', " +
                    "'ヨイド文失島)ハンガン公園 シェードツリー広場(スタート地点) およびハンガン一帯', '事前予約', " +
                    "'42km 4万ウォン、25km 3万5千ウォン、 15km 3万ウォン');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('45', 'ハンガン夏の生態学校'," +
                    "'ハンガンで自然とともに暑さを吹き飛ばそう!', '7.20(金)~8.19(日) 10:00~21:30', " +
                    "'ナンジ(蘭芝)、イチョン(三村)、チャムォン(蚕院)、 トゥクソム、チャムシル(蚕室)、クァンナルなど', '事前予約', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('46', 'ハンガンサマーキャンプ場'," +
                    "'都心のハンガン沿いで楽しむ真夏の夜', '7.13(金)~8.26(日)、15:00~翌日11:00', " +
                    "'ヨイド(波笑島)&トゥクソム・ハンガン公園', '事前予約', " +
                    "'1万5千ウォン~2万5千ウォン (キャンプ用品のレンタル料は別途');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('47', 'ハンガンデート'," +
                    "'ハンガンに流れる静かな感動', '7.28(土)~8.11(土)毎週土曜日および 8.19(日) 19:00~22:00', " +
                    "'ハンガン(漢江)の夜景スポット4か所 (パンポ(盤浦)、ヤンファ(楊花)、トゥクソム、 ヨイド(改矢島ハンガン(漢江公園)', '現場参加', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('48', 'ソウルバムトッケビナイトマーケット@ハンガン'," +
                    "'真夏の夜にハンガンで楽しむ見どころとグルメ!', '7.20(金)~8.19(日) 毎週金曜日 18:00~23:00、 土曜日 17:00~23:00', " +
                    "'ヨイド(改実島ハンガン公園 カスケード、 パンポ盤浦ハンガン公園月光広場一帯', '現場参加', " +
                    "'無料');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('49', '汉江水上乐园'," +
                    "'皮划艇、独木舟、桨板冲浪 (SUP)、水上自行车、 橡皮艇', '7.20(五)~8.19(日) 10:00~22:00 (无动力船截至19:00)\n', " +
                    "'汝矣岛Paradise附近的江面', '现场报名,提前预约', " +
                    "'收费(因项目而异)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('50', '汉江打水仗节'," +
                    "'用水球、水枪打一场毫无顾忌的水位', '8.4(六)~8.5(日) 11:00~18:00', " +
                    "'兰芝汉江公园青年广场', '提前预约、现场报名', " +
                    "'11000韩元');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('51', '汉江纸船竞赛'," +
                    "'乘着用纸做的船,在汉江展开的竞技大赛', '8.10(五)~8.12(日) 09:00~16:30', " +
                    "'蚕室汉江公园内蚕室交叉路前河岸边', '现场报名与提前预约', " +
                    "'50000韩元(以制作一艘船为标准)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('52', '汉江自行车兜风'," +
                    "'骑着自行车涼爽地绕汉江一周', '8.15(三)08:00~14:00', " +
                    "'汝矣岛汉江公园(出发地)', '通过手机应用程序“Open rider”提前预约', " +
                    "'1万韩元');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('53', '2018横渡汉江大挑战'," +
                    "'一起横渡汉江吧!', '8.19(日)09:00~17:00', " +
                    "'汉江蚕室大桥南端水中', '提前预约', " +
                    "'4万韩元');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('54', '汉江火舞节'," +
                    "'世界顶尖火舞艺术家带来的表演与烟花秀', '7.28(六)~7.29(日)17:00~22:00', " +
                    "'盘浦汉江公园艺光舞台一带', '现场参与', " +
                    "'免费');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('55', '汉江月光杂技团'," +
                    "'在汉江的月光下欣赏杂技团的表演', '8.3(五)~8.5(日) 18:00~22:00', " +
                    "'盘浦汉江公园三光岛前', '现场参与', " +
                    "'免费');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('56', '盛夏夜爵士'," +
                    "'一起到汉江野餐欣赏爵士乐', '8.14(二)~8.15(三)18:00~22:00', " +
                    "'盘浦汉江公园三光岛前野餐区', '现场观看', " +
                    "'免费');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('57', '汉江桥底电影节'," +
                    "'盛夏夜的特色电影院', '7.21(六)~8.18(六)每周六20:00~22:00', " +
                    "'广渡口千户、藤岛清潭、汝矣岛元晓大桥、 望远城山大桥附近草地', '现场自由观看', " +
                    "'免费');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('58', '桥底旧书摊节'," +
                    "'到汉江桥底进驻市市中心最大规模的旧书集市', '8.1 (三)~8.15(三) 11:00~22:00', " +
                    "'汝矣岛汉江公园麻浦大桥南端桥下', '提前预约与现场参与', " +
                    "'免费');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('59', '汉江星光小剧场'," +
                    "'各种演出、展览、游戏体验等; 专为家庭游客打造的综合礼包', '8.10(五)~8.12(日) 15:00~22:00', " +
                    "'汝矣岛汉江公园活动广场一带', '现场参与', " +
                    "'免费');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('60', '汉江夜间行走42公里'," +
                    "'伴随月光一起出发,和黎明一起抵达 汉江彻夜行走(42公里、25公里、15公里3种路线)', '7.28(六)16:00-次日07:00', " +
                    "'汝矣岛汉江公园绿荫树广场出发地) 及汉江一带', '提前预约', " +
                    "'42公里4万韩元、25公里3万5千韩元、 15公里3万韩元');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('61', '汉江夏季生态学校'," +
                    "'走进汉江的大自然,清凉一夏!', '7.20(五)~8.19(日) 10:00~21:30', " +
                    "'兰芝、二村、蚕院、藤岛、蚕室、广渡口等', '提前预约', " +
                    "'免费');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('62', '汉江夏日露营场'," +
                    "'在市中心的汉江边享受盛夏夜', '7.13(五)~8.26(日) 15:00~次日11:00', " +
                    "'汝矣岛、藤岛汉江公园', '提前预约', " +
                    "'1万5千韩元~2万5千韩元 (露营用品租借费用另计)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('63', '汉江约会'," +
                    "'汉江里潺潺流淌的感动', '7.28(六)~8.11(六)每周六及 8.19(日)19:00~22:00', " +
                    "'汉江4个知名的夜间景点 (盘浦、杨花、藤岛、汝矣岛汉江公园)', '现场参与', " +
                    "'免费');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('64', '首尔夜猫子夜市@汉江'," +
                    "'盛夏夜,汉江汇聚看点、美食与乐趣!', '7.20(五)~8.19(日) 每周五 18:00 ~ 23:00 每周六17:00~23:00', " +
                    "'汝矣岛汉江公园水光广场与 盘浦汉江公园月光广场一带', '现场参与', " +
                    "'免费入场');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('65', '漢江水上樂園'," +
                    "'皮艇、獨木舟、立榮衝浪(SUP)、水上自行車、 橡皮艇', '7.20(五)~8.19(日) 10:00~22:00 (無動力船截至19:00)', " +
                    "'蘭芝漢江公園青年廣場', '現場報名、提前預約', " +
                    "'收費(各活動不同)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('66', '漢江打水仗慶典'," +
                    "'用水球、水槍打一場毫無顧忌的水仪', '8.4(六)~8.5(日) 11:00~18:00', " +
                    "'蘭芝漢江公園青年廣場', '提前預約,現場報名', " +
                    "'11000韓元');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('67', '漢江紙船競賽'," +
                    "'乘著用紙做的船,在漢江展開的競速大賽', '8.10(五)~8.12(日) 09:00~16:30', " +
                    "'蠶室漢江公園內難室交叉路前河岸邊', '現場報名與提前預約', " +
                    "'50000韓元(以製作一艘船為標準)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('68', '漢江自行車兜風'," +
                    "'騎著自行車涼爽地統漢江一週', '8.15(三)08:00~14:00', " +
                    "'汝矣島漢江公園(出發地)', '透過手機APP「open rider」提前預約', " +
                    "'1萬韓元');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('69', '2018 橫渡漢江大挑戰'," +
                    "'一起横渡漢江吧!', '8.19(日)09:00~17:00', " +
                    "'漢江羲室大橋南端水中沙洲', '提前預約', " +
                    "'4萬韓元');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('70', '漢江火舞慶典'," +
                    "'世界頂尖火舞藝術家帶來的表演與煙火秀', '7.28(六)~7.29(日)17:00~22:00', " +
                    "'盤浦漢江公園藝光舞台一帶', '現場參與', " +
                    "'免費');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('71', '漢江月光馬戲團'," +
                    "'在漢江的月光下欣賞馬戲團的表演', '8.3(五)~8.5(日) 18:00~22:00', " +
                    "'盤浦漢江公園三光島前', '現場參與', " +
                    "'免費');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('72', '夏夜爵士慶典'," +
                    "'一起到漢江野餐欣賞爵士樂', '8.14(二)~8.15(三)18:00~22:00', " +
                    "'盤浦漢江公園三光島前野餐區', '現場觀看', " +
                    "'免費');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('73', '漢江橋下電影節'," +
                    "'盛夏夜的特色電影節', '7.21(六) ~ 8.18(六)每週六20:00~22:00', " +
                    "'廣渡口千戶、藤島清潭、汝矣島元曉大橋、 望遠城山大橋鄰近草地', '現場自行觀看', " +
                    "'免費');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('74', '橋底舊書攤慶典'," +
                    "'到漢江橋底市中心最大規模的舊書市集', '8.1(三)~8.15(三) 11:00~22:00', " +
                    "'汝矣島漢江公園麻浦大橋南端橋下', '提前預約與現場參與', " +
                    "'免費');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('75', '漢江星光小劇場'," +
                    "'多元的演出、展览、遊戲體驗等, 專為家庭遊客打造的綜合禮包', '8.10(五)~8.12(日) 15:00~22:00', " +
                    "'汝矣島漢江公園活動廣場一帶', '現場參與', " +
                    "'免費');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('76', '漢江夜間步行42公里'," +
                    "'伴隨月光一起出發,和黎明一起抵達 漢江徹夜步行(42公里、25公里、15公里,3種路線)', '7.28 16:00~隔天07:00', " +
                    "'汝矣島漢江公園綠蔭樹廣場(出發地) 與漢江一帶', '提前預約', " +
                    "'42公里4萬韓元、25公里3萬5千韓元、 15公里3萬韓元');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('77', '漢江夏季生態學校'," +
                    "'走進漢江的大自然,清凉一夏!', '7.20(五)~8.19(日) 10:00~21:30', " +
                    "'蘭芝、二村、籍院、囊盒、籍室、廣渡口等', '提前預約', " +
                    "'免費');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('78', '漢江夏日露營場'," +
                    "'在市中心的漢江邊享受盛夏夜', '7.13(五)~8.26(日)15:00~隔天11:00', " +
                    "'汝矣島、藤島漢江公園', '提前預約', " +
                    "'1萬5千韓元~2萬5千韓元 (露營用品租借費用另計)');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('79', '漢江約會'," +
                    "'漢江裡濕潺流淌的感動', '7.28(六)~8.11(六)每週六及 8.19(日)19:00~22:00', " +
                    "'漢江4個知名的夜間景點 (盤浦漢江公園、汝矣島漢江公園等)', '現場參與', " +
                    "'免費');");

            db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('80', '首爾夜貓子夜市@漢江'," +
                    "'盛夏夜,漢江匯聚看點、美食與樂趣!', '7.20(五)~8.19(日) 每週五 18:00 ~ 23:00 每週六17:00~23:00', " +
                    "'汝矣島漢江公園水光廣場與 盤浦漢江公園月光廣場一帶', '現場參與', " +
                    "'免費入場');");

        }

        //DB버전 업그레이드시, 기존 DB 삭제하고 다시 만듬
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DataBase.CreateDB.TABLENAME);
            onCreate(db);
        }

    }


    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    //인덱스값 받아와서 db 조회해서 커서(쿼리결과) 넘겨줌
    public Cursor executeRawQuery(int index){
        Cursor cursor=mDB.rawQuery("select * from hangang where _id="+index+";",null);

        return cursor;
    }

    public void close(){
        mDB.close();
    }
}
