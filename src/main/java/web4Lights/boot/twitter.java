package web4Lights.boot;

import ch.qos.logback.core.status.StatusListener;
import org.apache.commons.lang3.ArrayUtils;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Created by nmmoo on 1/29/2017.
 */
public class twitter {

    private List<Status> statusGet;
    private int howMany;
    private Twitter tweet;
    private QueryResult searchedFor;
    private StatusListener listener;


    private String mooreLightsConsumerKey;
    private String mooreLightsConsumerKeySecret;
    private String mooreLightsAccessToken;
    private String mooreLightsAccessTokenSecret;
    private long[] mooreLightsUserID;
    private String[] keywordSearches;
    private String mooreLightsUserTimeLine;




    public void addToList(Status statusToAdd)
    {
        statusGet.add(statusToAdd);
    }

    public void setQueryResult(QueryResult q)
    {
        searchedFor = q;
        //statusGet = q.getTweets();
        /*
        for(int i = 0; i < q.getCount(); i++)
        {
            statusGet.add(q.getTweets().get(i));
        }
        */
        statusGet.addAll(q.getTweets());
        return;
    }

    public QueryResult getQueryResult()
    {
        return searchedFor;
    }

    public void setList(List<Status> l)
    {
        statusGet = l;

        //statusGet.addAll(l);
        return;
    }

    public List<Status> getList()
    {
        return statusGet;
    }

    public Status getSingleEntry(int lookingFor)
    {
        return statusGet.get(lookingFor);
    }

    public void setTwit(Twitter t)
    {
        tweet = t;
        return;
    }

    public Twitter getTwit()
    {
        return tweet;
    }

    public String getSingleHtml()
    {

        Random randNum = new Random(System.currentTimeMillis());
        //int toReturn = randNum.nextInt(getQueryResult().getTweets().size());

        int toReturn = randNum.nextInt((getList().size() -1) +1) +1;

        //int toReturn = randNum.nextInt(getList().size()-1);
        //toReturn = toReturn % getList().size();
        if(toReturn > 1)
        {
            toReturn = toReturn-1;
        }


        System.out.println(toReturn);

        QueryResult res = getQueryResult();
        //Status show = res.getTweets().get(toReturn);
        Status show = getSingleEntry(toReturn);

        //MediaEntity me[] = show.getExtendedMediaEntities();
        //me[4].getType();


        Long tweetID = show.getId();
        OEmbedRequest toGet = new OEmbedRequest(tweetID, "https://api.twitter.com/1.1/statuses/oembed.json?id=");
        toGet.setHideMedia(false);
        toGet.setMaxWidth(500);
        toGet.omitScript(true);




        String retHTML = "No Social right now :(";
        try {
            /*Twitter getThisOne = getTwit();
            OEmbed gottenThis = getThisOne.getOEmbed(toGet);
            String recHtml = gottenThis.getHtml();
            System.out.println(recHtml);
            */
            retHTML = getTwit().getOEmbed(toGet).getHtml();
            howMany = getList().size();
            System.out.println(retHTML);
        }
        catch(TwitterException te)
        {
            System.out.println("Twit exception");
        }

        return retHTML;
    }



    public String getSpecificHtml(int whichTweet)
    {
        Status show = getSingleEntry(whichTweet);


        Long tweetID = show.getId();
        OEmbedRequest toGet = new OEmbedRequest(tweetID, "https://api.twitter.com/1.1/statuses/oembed.json?id=");
        toGet.setHideMedia(false);
        toGet.setMaxWidth(500);
        toGet.omitScript(true);




        String retHTML = "No Social right now :(";
        try {
            /*Twitter getThisOne = getTwit();
            OEmbed gottenThis = getThisOne.getOEmbed(toGet);
            String recHtml = gottenThis.getHtml();
            System.out.println(recHtml);
            */
            retHTML = getTwit().getOEmbed(toGet).getHtml();
            howMany = getList().size();
            System.out.println(retHTML);
        }
        catch(TwitterException te)
        {
            System.out.println("Twit exception");
        }

        return retHTML;
    }



    public void getTweets()
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(mooreLightsConsumerKey)
                .setOAuthConsumerSecret(mooreLightsConsumerKeySecret)
                .setOAuthAccessToken(mooreLightsAccessToken)
                .setOAuthAccessTokenSecret(mooreLightsAccessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        setTwit(twitter);
//////////////////////////////////////////////////////////////////////////////////////
/*
        try
        {
            setList(twitter.getHomeTimeline());

            Status show = getSingleEntry(4);
            Long tweetID = show.getId();
            OEmbedRequest toGet = new OEmbedRequest(tweetID, "https://api.twitter.com/1.1/statuses/oembed.json?id=");

            howMany = getList().size();


            System.out.println(twitter.getOEmbed(toGet).getHtml());
            //System.out.println(s.getId() + "......" + s.getURLEntities());
            System.out.println();
            System.out.println();

*/
        /*
            for(Status s:getList())
            {
                Long tweetID = s.getId();
                OEmbedRequest toGet = new OEmbedRequest(tweetID, "https://api.twitter.com/1.1/statuses/oembed.json?id=");
                System.out.println(twitter.getOEmbed(toGet).getHtml());
                //System.out.println(s.getId() + "......" + s.getURLEntities());
                System.out.println();
                System.out.println();
            }
        */
/*
        }
        catch (TwitterException e)
        {
            System.out.println("get timeline: " + e + " status code: " + e.getStatusCode());
        }
*/



    }

    public twitter()
    {
        Properties prop = new Properties();
        InputStream input = null;

        try
        {
            input = new FileInputStream("src/main/resources/twitterAccount.properties");
            prop.load(input);
            mooreLightsConsumerKey = prop.getProperty("consumerKey").toString();
            mooreLightsConsumerKeySecret = prop.getProperty("consumerKeySecret").toString();
            mooreLightsAccessToken = prop.getProperty("accessToken").toString();
            mooreLightsAccessTokenSecret = prop.getProperty("accessTokenSecret").toString();
            String[] userIDArray = prop.get("userID").toString().split(",");
            ArrayList<Long> tempID = new ArrayList<Long>();
            for(int i = 0; i < userIDArray.length; i++)
            {
                tempID.add(Long.parseLong(userIDArray[i]));
            }
            long[] tempLongID = new long[tempID.size()];
            for(int j = 0; j < tempLongID.length; j++)
            {
                tempLongID[j] = tempID.get(j);
            }
            mooreLightsUserID = tempLongID;
            keywordSearches = prop.getProperty("keyWords").toString().split("'");
            mooreLightsUserTimeLine = prop.getProperty("userTimeline").toString();


            System.out.println();

        }
        catch (FileNotFoundException nf)
        {
            System.out.println("File not found. Here is your Stack trace:");
            nf.printStackTrace();
        }
        catch (IOException io)
        {
            System.out.println("Reading File Error. Here is your Stack trace:");
            io.printStackTrace();
        }


        ConfigurationBuilder cb = new ConfigurationBuilder();
        ConfigurationBuilder cb2 = new ConfigurationBuilder();
        cb2.setDebugEnabled(true)
                .setOAuthConsumerKey(mooreLightsConsumerKey)
                .setOAuthConsumerSecret(mooreLightsConsumerKeySecret)
                .setOAuthAccessToken(mooreLightsAccessToken)
                .setOAuthAccessTokenSecret(mooreLightsAccessTokenSecret);
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(mooreLightsConsumerKey)
                .setOAuthConsumerSecret(mooreLightsConsumerKeySecret)
                .setOAuthAccessToken(mooreLightsAccessToken)
                .setOAuthAccessTokenSecret(mooreLightsAccessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();



        String test = "this";
        try
        {

            setList(twitter.getUserTimeline(mooreLightsUserTimeLine));
            setTwit(twitter);
        }
        catch (TwitterException e)
        {
            System.out.println("get timeline: " + e + " status code: " + e.getStatusCode());
        }

        howMany = getList().size();



/*

        twitter4j.StatusListener tweetListener = new twitter4j.StatusListener()
        {

            public void onStatus(Status status)
            {
                System.out.println("new Tweet Came in");
                addToList(status);
                System.out.println("Added to available list");
                System.out.println(getList().size());
            }

            public void onDeletionNotice(StatusDeletionNotice deleteNotice){}
            public void onTrackLimitationNotice(int numOfLimitStatus){}

            @Override
            public void onScrubGeo(long l, long l1) {

            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {

            }

            public void onException(Exception listenEx)
            {
                listenEx.printStackTrace();
            }
        };


        TwitterStream twitterStream = new TwitterStreamFactory(cb2.build()).getInstance();

        twitterStream.addListener(tweetListener);
        long moore_lights_userID = 833115040685268993L;
        //FilterQuery fq = new FilterQuery();
        FilterQuery fq = new FilterQuery(); //moore_lights userID = 833115040685268993
        String keywords[] = {"mooreLights"};
        long usersToFollow[] = {moore_lights_userID};
        fq.track(keywords);
        fq.follow(usersToFollow);


        twitterStream.filter(fq);


*/




        UserStreamListener sc = new UserStreamListener() {
            @Override
            public void onDeletionNotice(long l, long l1) {

            }

            @Override
            public void onFriendList(long[] longs) {

            }

            @Override
            public void onFavorite(User user, User user1, Status status) {

            }

            @Override
            public void onUnfavorite(User user, User user1, Status status) {

            }

            @Override
            public void onFollow(User user, User user1) {

            }

            @Override
            public void onUnfollow(User user, User user1) {

            }

            @Override
            public void onDirectMessage(DirectMessage directMessage) {

            }

            @Override
            public void onUserListMemberAddition(User user, User user1, UserList userList) {

            }

            @Override
            public void onUserListMemberDeletion(User user, User user1, UserList userList) {

            }

            @Override
            public void onUserListSubscription(User user, User user1, UserList userList) {

            }

            @Override
            public void onUserListUnsubscription(User user, User user1, UserList userList) {

            }

            @Override
            public void onUserListCreation(User user, UserList userList) {

            }

            @Override
            public void onUserListUpdate(User user, UserList userList) {

            }

            @Override
            public void onUserListDeletion(User user, UserList userList) {

            }

            @Override
            public void onUserProfileUpdate(User user) {

            }

            @Override
            public void onBlock(User user, User user1) {

            }

            @Override
            public void onUnblock(User user, User user1) {

            }

            @Override
            public void onStatus(Status status) {


                System.out.println("new Tweet Came in");
                addToList(status);
                System.out.println("Added to available list");
                System.out.println(getList().size());

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int i) {

            }

            @Override
            public void onScrubGeo(long l, long l1) {

            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {

            }

            @Override
            public void onException(Exception e) {

            }

        };




        TwitterStream twitterStreamUser = new TwitterStreamFactory(cb2.build()).getInstance();

        twitterStreamUser.addListener(sc);

        long[] moore_lights_userID = mooreLightsUserID;

        //FilterQuery fq = new FilterQuery();
        FilterQuery fq2 = new FilterQuery();
        String keywords2[] = keywordSearches;
        long usersToFollow2[] = moore_lights_userID;
        fq2.track(keywords2);
        fq2.follow(usersToFollow2);


        twitterStreamUser.filter(fq2);





    }



}
