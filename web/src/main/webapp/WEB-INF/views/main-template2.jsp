<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"
	scope="request" />
<c:set var="pagesMode" value="${contextPath}/mode" scope="request" />
<c:set var="pagesCountry" value="${contextPath}/country" scope="request" />
<c:set var="pagesPlayer" value="${contextPath}/player" scope="request" />
<c:set var="pagesClub" value="${contextPath}/club" scope="request" />
<c:set var="pagesGame" value="${contextPath}/game" scope="request" />
<c:set var="pagesTournament" value="${contextPath}/tournament"
	scope="request" />
<c:set var="pagesParticipation" value="${contextPath}/participation"
	scope="request" />
<c:set var="pagesPlay" value="${contextPath}/play" scope="request" />


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><tiles:insertAttribute name="title" /></title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet" href="${contextPath}/resources/css/custom.css">

</head>


<body class="scrollbar-obtrusive">
      <div class="base-layout">
                                            <div class="base-sidebar">
          

  


<div id="new-game-modal"></div>

<div id="login-register-modal"><!----></div>

<div id="shareable-game-url-modal"></div>

<div id="message-modal"></div>

<div id="achievements-modal"></div>

<div id="puzzle-battle-challenge-toaster"><!----></div>

<div id="notification-toasters"><div class="toasters-container svelte-7ld7cj"><div class="toasters-list svelte-7ld7cj"></div></div></div>

  <div id="offline-challenge-toaster" data-badge="challenges" data-badge-count="0"><!----></div>

  <div id="old-browser-modal"></div>

    
<div id="sb" class="guest" data-challenge-user="null" data-constant-message-unread-count-max="100" data-disabled-old-lessons="true" data-feature-leagues="" data-feature-board-layout-resize-bottom="true" data-feature-navigation-user-connection="" data-feature-new-notifications="" data-feature-old-board-sound-delay="true" data-feature-saved-analysis-listing="" data-feature-user-messages-overflow="true" data-feature-upgrade-modals-redesign="" data-firebase-support="" data-feature-iterable-track-without-email="true" data-is-live="" data-route-login-and-go="https://www.chess.com/login_and_go" data-route-register="https://www.chess.com/register" data-show-challenge-user="">
    <div class="action toggle close">
    <div class="icon-font">
      <span class="icon-font-chess x"></span>
    </div>
  </div>

    <div class="menu top">
    
        <a aria-label="Chess.com - Play Chess Online" data-panel="notifications" class="link main-link chess-logo-wrapper sprite chess-logo" href="https://www.chess.com/" target="_self">
                        <!---->
                  </a>
    
    
        <a data-panel="play" href="https://www.chess.com/play/computer" target="_self" class="link main-link sprite play">
      <span class="text">Play</span>
              <!---->
          </a>
    
        
    <div class="nav-panel play" data-routes="{&quot;leaderboard&quot;:&quot;https:\/\/www.chess.com\/leaderboard\/live&quot;,&quot;live&quot;:&quot;https:\/\/www.chess.com\/live&quot;,&quot;daily&quot;:&quot;https:\/\/www.chess.com\/daily&quot;,&quot;computer&quot;:&quot;https:\/\/www.chess.com\/play\/computer&quot;,&quot;puzzleBattle&quot;:&quot;https:\/\/www.chess.com\/puzzles\/battle&quot;,&quot;puzzles&quot;:&quot;https:\/\/www.chess.com\/puzzles\/rush&quot;,&quot;tournaments&quot;:&quot;https:\/\/www.chess.com\/tournaments&quot;,&quot;leagues&quot;:&quot;https:\/\/www.chess.com\/leagues&quot;,&quot;fourPlayer&quot;:&quot;https:\/\/www.chess.com\/4-player-chess&quot;,&quot;gameArchive&quot;:&quot;https:\/\/www.chess.com\/games\/archive&quot;}">
    </div>
    
        <a data-panel="puzzles" href="https://www.chess.com/puzzles" target="_self" class="link main-link sprite tactics">
      <span class="text">Puzzles</span>
    </a>
    
        
    <div class="nav-panel puzzles" data-routes="{&quot;dailyPuzzle&quot;:&quot;https:\/\/www.chess.com\/goto_daily_puzzle&quot;,&quot;drills&quot;:&quot;https:\/\/www.chess.com\/drills&quot;,&quot;puzzleBattle&quot;:&quot;https:\/\/www.chess.com\/puzzles\/battle&quot;,&quot;puzzles&quot;:&quot;https:\/\/www.chess.com\/puzzles\/rush&quot;,&quot;tactics&quot;:&quot;https:\/\/www.chess.com\/puzzles&quot;,&quot;soloChess&quot;:&quot;https:\/\/www.chess.com\/solo-chess&quot;}">
    </div>
    
        <a data-panel="learn" href="https://www.chess.com/lessons" target="_self" class="link main-link sprite learn">
      <span class="text">Learn</span>
    </a>
    
        
    <div class="nav-panel learn" data-routes="{&quot;articles&quot;:&quot;https:\/\/www.chess.com\/articles&quot;,&quot;tactics&quot;:&quot;https:\/\/www.chess.com\/puzzles&quot;,&quot;lessons&quot;:&quot;https:\/\/www.chess.com\/lessons&quot;,&quot;videos&quot;:&quot;https:\/\/www.chess.com\/videos&quot;,&quot;openings&quot;:&quot;https:\/\/www.chess.com\/openings&quot;,&quot;explorer&quot;:&quot;https:\/\/www.chess.com\/explorer&quot;,&quot;drills&quot;:&quot;https:\/\/www.chess.com\/drills&quot;,&quot;vision&quot;:&quot;https:\/\/www.chess.com\/vision&quot;,&quot;analysis&quot;:&quot;https:\/\/www.chess.com\/analysis&quot;}">
    </div>
    
        <a data-panel="connect" href="https://www.chess.com/forum" target="_self" class="link main-link sprite connect">
      <span class="text">Connect</span>

          </a>
    
    
    <div class="nav-panel connect" data-routes="{&quot;articles&quot;:&quot;https:\/\/www.chess.com\/articles&quot;,&quot;news&quot;:&quot;https:\/\/www.chess.com\/news&quot;,&quot;forums&quot;:&quot;https:\/\/www.chess.com\/forum&quot;,&quot;blogs&quot;:&quot;https:\/\/www.chess.com\/blogs&quot;,&quot;clubs&quot;:&quot;https:\/\/www.chess.com\/clubs&quot;,&quot;friends&quot;:&quot;https:\/\/www.chess.com\/home\/friends&quot;,&quot;members&quot;:&quot;https:\/\/www.chess.com\/members&quot;,&quot;coaches&quot;:&quot;https:\/\/www.chess.com\/coaches&quot;,&quot;chessToday&quot;:&quot;https:\/\/www.chess.com\/today&quot;}">
    </div>

        
    <a data-panel="today" href="https://www.chess.com/today" target="_self" class="link main-link sprite tv">
      <span class="text">Today</span>
    </a>
    
        
    <div class="nav-panel today" data-routes="{&quot;chessToday&quot;:&quot;https:\/\/www.chess.com\/today&quot;,&quot;computerChampionship&quot;:&quot;https:\/\/www.chess.com\/computer-chess-championship&quot;,&quot;news&quot;:&quot;https:\/\/www.chess.com\/news&quot;,&quot;speedChessChampionship&quot;:&quot;https:\/\/www.chess.com\/article\/view\/2019-speed-chess-championship&quot;,&quot;proChessLeague&quot;:&quot;http:\/\/www.prochessleague.com&quot;,&quot;streamers&quot;:&quot;https:\/\/www.chess.com\/streamers&quot;}">
    </div>
    
        <a data-panel="more" href="https://www.chess.com/goto_daily_puzzle" target="_self" class="link main-link sprite more">
      <span class="text">More</span>
    </a>
    
        
    <div class="nav-panel more" data-routes="{&quot;computerChampionship&quot;:&quot;https:\/\/www.chess.com\/computer-chess-championship&quot;,&quot;dailyPuzzle&quot;:&quot;https:\/\/www.chess.com\/goto_daily_puzzle&quot;,&quot;leaderboard&quot;:&quot;https:\/\/www.chess.com\/leaderboard\/live&quot;,&quot;liveRankings&quot;:&quot;https:\/\/www.chess.com\/ratings&quot;,&quot;masterGames&quot;:&quot;https:\/\/www.chess.com\/games&quot;,&quot;voteChess&quot;:&quot;https:\/\/www.chess.com\/votechess&quot;,&quot;soloChess&quot;:&quot;https:\/\/www.chess.com\/solo-chess&quot;,&quot;topPlayers&quot;:&quot;https:\/\/www.chess.com\/players&quot;,&quot;resourcesPage&quot;:&quot;https:\/\/www.chess.com\/resources&quot;,&quot;mobileApps&quot;:&quot;https:\/\/www.chess.com\/play\/apps&quot;,&quot;rules&quot;:&quot;https:\/\/www.chess.com\/learn-how-to-play-chess&quot;}">
    </div>
    
    
                    <a href="https://www.chess.com/login_and_go?returnUrl=https%3A%2F%2Fwww.chess.com%2F" target="_self" rel="nofollow" class="button auth login">
        <div class="icon-font icon">
          <span class="icon-font-chess follow"></span>
        </div>
        <span class="label">Log In</span>
      </a>
      
      
            <a data-amplitude-props="{&quot;source&quot;:&quot;Unknown&quot;}" href="https://www.chess.com/register?returnUrl=https%3A%2F%2Fwww.chess.com%2F" target="_self" rel="nofollow" class="button auth signup register">
        <div class="icon-font icon">
          <span class="icon-font-chess user-plus"></span>
        </div>
        <span class="label">Sign Up</span>
      </a>
                </div>
    <div class="menu">
            
            
            
        <a href="https://www.chess.com/search" target="_self" class="action search">
      <div class="toggle-search-box" data-tooltip-show="collapsed-nav" data-tooltip-content="Search">
        <div class="icon-font">
          <span class="icon-font-chess magnifying-glass"></span>
        </div>
        <span class="nav-label">Search</span>
      </div>
            <div class="svelte popover search">
        <div class="arrow"></div>
        <form action="https://www.chess.com/search/redirect" method="GET">
          <input type="text" name="q">
        </form>
      </div>
          </a>
    
        <a class="action has-popover help">
      <div class="icon-font">
        <span class="icon-font-chess circle-question"></span>
      </div>
      <span class="text">Help</span>
    </a>
    
        <div class="svelte dark popover help">
            <div class="arrow"></div>
      
            <a class="help-scout">
        <div class="icon-font icon">
          <span class="icon-font-chess circle-question"></span>
        </div>
        <span class="title">Ask a Question</span>
      </a>
      
            <a rel="noopener" href="https://support.chess.com/collection/136-community-safety" target="_blank">
        <div class="icon-font icon">
          <span class="icon-font-chess circle-block"></span>
        </div>
        <span class="title">Report Abuse</span>
      </a>
      
            <a class="user-snap">
        <div class="icon-font icon">
          <span class="icon-font-chess lightbulb"></span>
        </div>
        <span class="title">Make a Suggestion</span>
      </a>
      
            <a rel="noopener" href="https://support.chess.com/category/135-membership-and-billing" target="_blank">
        <div class="icon-font icon">
          <span class="icon-font-chess card"></span>
        </div>
        <span class="title">Billing Issues</span>
      </a>
      
            <a class="user-snap">
        <div class="icon-font icon">
          <span class="icon-font-chess bug"></span>
        </div>
        <span class="title">Report a Bug</span>
      </a>
          </div>
      </div>
  </div>


          </div>
      
            <div class="base-container" tabindex="0">
        <div id="scroll-top-anchor"></div>

                          
                          <div id="language-banner"></div>
        
                            <header id="tb">
    <div class="menu">
        <div class="action toggle open">
      <div class="icon-font">
        <span class="icon-font-chess menu"></span>
      </div>
    </div>
    
        <a href="https://www.chess.com/" class="link chess-logo-wrapper sprite chess-logo" aria-label="Chess.com - Play Chess Online">
    </a>
      </div>
  
  </header>
        
                  <div class="layout-one-column-component">

    <main class="layout-one-column-column">
          

<section class="guest-component">
  <div class="guest-grid-item guest-board-preview">
    <div class="guest-player guest-player-black">
      <div class="guest-player-wrapper">
        <img alt="Black Player" class="guest-player-placeholder" height="40" src="/bundles/web/images/black_400.918cdaa6.png" width="40">

        <div class="guest-player-username">Opponent</div>
      </div>

      <div class="guest-timer">10:00</div>
    </div>

    <img alt="Board" class="guest-board-img" src="/bundles/web/images/offline-play/standardboard.6a504885.png">

    <div class="guest-player guest-player-white">
      <div class="guest-player-wrapper">
        <img alt="White Player" class="guest-player-placeholder" height="40" src="/bundles/web/images/white_400.09ae248e.png" width="40">

        <div class="guest-player-username-block">
          <div class="guest-player-username">GuestPlayer</div>

          <div class="guest-player-rating">(1200)</div>

          <div class="country-flags-component country-2"></div>
        </div>
      </div>

      <div class="guest-timer">10:00</div>
    </div>
  </div>

  <header class="section-container-component section-container-darkMode guest-grid-item guest-intro">
    <h1 class="guest-title">
      Play and Learn Chess on the #1 Site
    </h1>

    
    <ul class="guest-infographic">
              <li class="guest-infographic-item">
              
  <div class="icon-font-component guest-infographic-icon
    ">
    <span class="icon-font-chess chess-board"></span>
  </div>



          4,447,514 Games / Day
        </li>
              <li class="guest-infographic-item">
              
  <div class="icon-font-component guest-infographic-icon
    ">
    <span class="icon-font-chess users"></span>
  </div>



          34,690,320 Members
        </li>
              <li class="guest-infographic-item">
              
  <div class="icon-font-component guest-infographic-icon
    ">
    <span class="icon-font-chess chess-crown"></span>
  </div>



          601 Masters Playing Now
        </li>
          </ul>

          <a href="https://www.chess.com/register" class="form-button-component form-button-x-large form-button-primary form-button-full-width guest-play-btn">
        Play Now
      </a>
    
    <div class="guest-play-more">
      
              <a href="https://www.chess.com/lessons" class="guest-play-more-link">
          <div class="guest-play-more-img guest-learn"></div>

          Learn to Play
        </a>
              <a href="https://www.chess.com/play/computer" class="guest-play-more-link">
          <div class="guest-play-more-img guest-computer"></div>

          Play Computer
        </a>
              <a href="https://www.chess.com/goto_daily_puzzle" class="guest-play-more-link">
          <div class="guest-play-more-img guest-tactics"></div>

          Daily Puzzle
        </a>
          </div>
  </header>
</section>

  <section class="section-container-component section-container-darkMode">
    <div class="index-suggestion-component">
      <div class="index-suggestion-board">
        <img alt="Solve Chess Puzzles" class="index-suggestion-board-img" src="/bundles/web/images/web/board-puzzles.600ddf36.png" srcset="/bundles/web/images/web/board-puzzles.600ddf36@2x.png">
      </div>

      <div class="index-suggestion-info">
        <div class="index-suggestion-header">
          <h2 class="index-suggestion-title">
            Solve Chess Puzzles
          </h2>

          <a href="https://www.chess.com/puzzles" class="form-button-component form-button-primary form-button-x-large">
            Solve Puzzles
          </a>
        </div>

        <div class="index-quote">
          <img alt="Hikaru Nakamura" class="index-quote-img" src="/bundles/web/images/faces/hikaru-nakamura.8e6d6748.jpg" data-src="/bundles/web/images/faces/hikaru-nakamura.8e6d6748.jpg" width="160">

          <blockquote class="index-quote-inner">
            <p class="index-quote-body index-quote-limit-230">
              "Puzzles are the best way to improve pattern recognition, and no site does it better."
            </p>

            <div class="index-quote-author">
              <div class="index-chess-title">GM</div>

              Hikaru Nakamura
            </div>
          </blockquote>
        </div>
      </div>
    </div>
  </section>

    <section class="section-container-component section-container-darkMode">
    <div class="index-suggestion-component">
      <div class="index-suggestion-board">
        <img alt="Take Chess Lessons" class="index-suggestion-board-img" src="/bundles/web/images/web/board-lessons.4f9a9194.png" data-src="/bundles/web/images/web/board-lessons.4f9a9194.png" data-srcset="/bundles/web/images/web/board-lessons.4f9a9194@2x.png" srcset="/bundles/web/images/web/board-lessons.4f9a9194@2x.png">
      </div>

      <div class="index-suggestion-info">
        <div class="index-suggestion-header">
          <h2 class="index-suggestion-title">
            Take Chess Lessons
          </h2>

          <a class="form-button-component form-button-primary form-button-x-large" href="https://www.chess.com/lessons">
            Start Lessons
          </a>
        </div>

        <div class="index-quote">
          <img alt="Anna Rudolf" class="index-quote-img" src="https://betacssjs.chesscomfiles.com/bundles/web/images/faces/anna-rudolf.31322abb.jpg" data-src="https://betacssjs.chesscomfiles.com/bundles/web/images/faces/anna-rudolf.31322abb.jpg" width="160">

          <blockquote class="index-quote-inner">
            <p class="index-quote-body index-quote-limit-245">
              "Chess.com lessons make it easy to learn to play, then challenge you to continue growing."
            </p>

            <div class="index-quote-author">
              <div class="index-chess-title">IM</div>

              Anna Rudolf
            </div>
          </blockquote>
        </div>
      </div>
    </div>
  </section>

    <div class="index-posts-component">
    <h2 class="index-post-header">
      <a href="https://www.chess.com/today" class="index-post-link">
        Follow what's happening in Chess Today.
      </a>
    </h2>

    
          <article class="index-post-preview">
      
    
      
  <a href="https://www.chess.com/news/view/fide-postpones-chess-olympiad-to-2021">
    <div class="index-post-preview-img">
      
                    
      <img alt="FIDE Postpones Chess Olympiad To 2021" class="index-post-preview-thumbnail img-defer " data-src="https://images.chesscomfiles.com/uploads/v1/news/596922.3bfee9fe.507x286o.c2707532cbeb.jpeg" data-srcset="https://images.chesscomfiles.com/uploads/v1/news/596922.3bfee9fe.507x286o.c2707532cbeb@2x.jpeg 2x" src="/bundles/web/images/image-default.52fd5825.svg">

          </div>

    <h3 class="index-post-preview-title">FIDE Postpones Chess Olympiad To 2021</h3>
  </a>
</article>
    
    
              
          <article class="index-post-preview">
      
    
      
  <a href="https://www.chess.com/news/view/2020-fide-candidates-chess-tournament-round-6">
    <div class="index-post-preview-img">
      
                    
      <img alt="FIDE Candidates Tournament: Nepomniachtchi Increases Lead, Giri Beats Alekseenko" class="index-post-preview-thumbnail img-defer " data-src="https://images.chesscomfiles.com/uploads/v1/news/595726.7ec91f37.507x286o.b301b187febb.jpeg" data-srcset="https://images.chesscomfiles.com/uploads/v1/news/595726.7ec91f37.507x286o.b301b187febb@2x.jpeg 2x" src="/bundles/web/images/image-default.52fd5825.svg">

          </div>

    <h3 class="index-post-preview-title">FIDE Candidates Tournament: Nepomniachtchi Increases Lead, Giri Beats Alekseenko</h3>
  </a>
</article>
          <article class="index-post-preview">
      
    
      		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
  <a href="https://www.chess.com/article/view/anand-vs-ivanchuk-comedies-tragedies-and-masterpieces">
    <div class="index-post-preview-img">
      
                    
      <img alt="Comedies, Tragedies, And Masterpieces: Anand vs Ivanchuk II" class="index-post-preview-thumbnail img-defer " data-src="https://images.chesscomfiles.com/uploads/v1/article/25482.025c851c.507x286o.104b51f735b3.jpeg" data-srcset="https://images.chesscomfiles.com/uploads/v1/article/25482.025c851c.507x286o.104b51f735b3@2x.jpeg 2x" src="/bundles/web/images/image-default.52fd5825.svg">

          </div>

    <h3 class="index-post-preview-title">Comedies, Tragedies, And Masterpieces: Anand vs Ivanchuk II</h3>
  </a>
</article>
          <article class="index-post-preview">
      
    
      
  <a href="https://www.chess.com/video/player/candidates-gotd-nepomniachtchi-ding">
    <div class="index-post-preview-img">
      
                    
      <img alt="Candidates GOTD: Nepomniachtchi - Ding" class="index-post-preview-thumbnail img-defer " data-src="https://images.chesscomfiles.com/uploads/v1/video/6884.392cb65d.507x286o.0d793cf14eee.png" src="/bundles/web/images/image-default.52fd5825.svg">

              <div class="icon-font-component post-preview-image-icon">
          <span class="icon-font-chess play"></span>
        </div>
          </div>

    <h3 class="index-post-preview-title">Candidates GOTD: Nepomniachtchi - Ding</h3>
  </a>
</article>
      </div>

    <div class="index-chess-today-component">
    <a class="form-button-component form-button-primary form-button-x-large" href="https://www.chess.com/today">
      Chess Today
    </a>
  </div>
    </main>

  </div>

                          <footer id="navigation-footer" class="navigation-footer-component navigation-footer-centered navigation-footer-component-one-column">
  <div class="navigation-footer-pages-component navigation-footer-left">
    <a href="https://support.chess.com" class="navigation-footer-page-component" target="_blank" rel="noopener">Help</a>

          <a href="https://www.chess.com/why" class="navigation-footer-page-component" target="_self">Why Join?</a>
    
    
          <a href="https://www.chess.com/about" class="navigation-footer-page-component" target="_self">
        About
      </a>
    
    <a href="https://www.chess.com/jobs" class="navigation-footer-page-component" target="_blank">
      Jobs
    </a>

    <a href="https://www.chess.com/developers" class="navigation-footer-page-component" target="_blank">
      Developers
    </a>

    <a href="https://www.chess.com/agreement" class="navigation-footer-page-component" target="_blank">
      User Agreement
    </a>

    <a href="https://www.chess.com/privacy" class="navigation-footer-page-component" target="_blank">
      Privacy Policy
    </a>

    <a href="https://www.chess.com/community" class="navigation-footer-page-component" target="_blank">
      Community Policies
    </a>

    <a href="https://www.chess.com/" class="navigation-footer-page-component" target="_self">
      Chess.com © 2020
    </a>
  </div>

  <div class="navigation-footer-platforms-component">
    <a aria-label="App for iOS / iPhone / iPad" class="navigation-footer-platform-component navigation-footer-platforms-apple" href="https://www.chess.com/play/apps/ios">
      <div class="icon-font-component navigation-footer-platform-icon">
        <span class="icon-font-chess apple icon-font-primary"></span>
      </div>
    </a>

    <a aria-label="App for Android" class="navigation-footer-platform-component navigation-footer-platforms-android navigation-footer-platforms-gutter" href="https://www.chess.com/play/apps/android">
      <div class="icon-font-component navigation-footer-platform-icon">
        <span class="icon-font-chess android icon-font-primary"></span>
      </div>
    </a>

    <a aria-label="Facebook" class="navigation-footer-platform-component navigation-footer-platforms-facebook" href="https://www.facebook.com/chess">
      <div class="icon-font-component navigation-footer-platform-icon">
        <span class="icon-font-chess facebook icon-font-primary"></span>
      </div>
    </a>

    <a aria-label="Twitter" class="navigation-footer-platform-component navigation-footer-platforms-twitter" href="https://twitter.com/chesscom">
      <div class="icon-font-component navigation-footer-platform-icon">
        <span class="icon-font-chess twitter icon-font-primary"></span>
      </div>
    </a>

    <a aria-label="Youtube" class="navigation-footer-platform-component navigation-footer-platforms-youtube" href="https://www.youtube.com/user/wwwChesscom">
      <div class="icon-font-component navigation-footer-platform-icon">
        <span class="icon-font-chess youtube icon-font-primary"></span>
      </div>
    </a>

    <a aria-label="Twitch" class="navigation-footer-platform-component navigation-footer-platforms-twitch" href="https://www.twitch.tv/chess">
      <div class="icon-font-component navigation-footer-platform-icon">
        <span class="icon-font-chess twitch icon-font-primary"></span>
      </div>
    </a>

    <a aria-label="Instagram" class="navigation-footer-platform-component navigation-footer-platforms-instagram" href="https://www.instagram.com/wwwchesscom">
      <div class="icon-font-component navigation-footer-platform-icon">
        <span class="icon-font-chess instagram icon-font-primary"></span>
      </div>
    </a>
  </div>
</footer>
              </div>
    </div>
  
          
    
  
  <div class="alert-flash-component" style="left: 145px;"></div>

      
    
    
  
  <script type="text/javascript">
    var Config = {
      "cometd.url": "/cometd",
      "domain.main": "//www.chess.com",
      "domain.static": "//betacssjs.chesscomfiles.com",
      "domain.files": "//files.chesscomfiles.com",
      "domain.live": "//live.chess.com",
      "domain.live2": "//live2.chess.com",
      "domain.liveh2": "//liveh2.chess.com",
      "domain.voice": "rtmp://voice.chess.com",
      "domain.cssjs": "//betacssjs.chesscomfiles.com",
      "domain.images": "//images.chesscomfiles.com",
      "domain.avatars": "//avatars.chesscomfiles.com",
      "domain.baseUrl": "",
      "isFacebookCanvas": false,
      "facebookId": "429665630433565",
      "pathToEngineWorker": "/bundles/app/js/vendor/jschessengine/stockfish.6983901b.js",
      "pathToDiagramViewerCSS": "/bundles/app/css/diagram-viewer.client.a8cc59f3.css",
      "pathToDiagramViewerJS": "/bundles/app/js/diagram-viewer.client.89068c82.js",
            "pathToJCE": "/bundles/app/js/vendor/jschessengine/jschessengine.min.005d7c16.js",
      "pathToWasmEngine": "/bundles/app/js/vendor/jschessengine/stockfish.6103b42f.bin",
      "pathToNonWasmEngine": "/bundles/app/js/vendor/jschessengine/stockfish.asm.1abfa10c.js",
      "pathToKomodoWorker": "/bundles/app/js/vendor/jschessengine/komodo.75017b80.js",
      "pathToWasmKomodo": "/bundles/app/js/vendor/jschessengine/komodo.b28431d8.bin",
      "pathToNonWasmKomodo": "/bundles/app/js/vendor/jschessengine/komodo.asm.79a4950f.js",
      "pathToEcoJson": "/bundles/app/js/common/json/eco.9cf2ee12.json",
      "pathToBook": "/bundles/app/js/vendor/jschessengine/books/book.c30917a9.json",
      "pathToWebGL": "/bundles/app/js/vendor/webgl_three.61269fce.js",
      "pathToGamePreviewLoader": "/bundles/web/images/game-preview-loading.8677fb94.png",
      "pathToTinyMCE": "/bundles/app/js/tinymce-lazy.client.e16f1884.js",
      "oldThemes": false,
      "isLive": false,
      "isStaff": false,
      "noAvatar": '/bundles/web/images/user-image.007dad08.svg',
      "ad.noAds": true,
      "ad.layout": "ros",
      "ad.disabledAds": []
    };

        window.__CHESSCOM_RTL__ = false;

        //<![CDATA[
    context = {"i18n":{"locale":"en_US","contentLanguage":"any","mobile":{"computer":"Computer","daily_chess":"Daily Chess","tactics":"Tactics","lessons":"Lessons","videos":"Videos","articles":"Articles","forums":"Forums","friends":"Friends","messages":"Messages","stats":"Stats","settings":"Settings","trophies":"Trophies"}},"csrf":{"token":"P8LtGzgyX4KUu3jA9UGiJCcavtwkhXffTTv1gadhc7I","logout":"63jVWp7enAKLhYPB1OdgQmQbbh8rLHlg4PwZqNE5d5c"},"amplitudeKey":"5cc41a1e56d0ee35d4c85d1d4225d2d1","iterableKey":"c5b41685f6a54f0a80671e425c1f52f0","adyenKey":"10001|D97C83A6DB30A889AAC517489C56512C733B365B8E5E2E5CB5FD860751EC3EC14A145FE6FD2EF1A338D375DB3D9F7B988631B64D4B9C9BE3DE007D8C60649F2BAC7B0798A869892B683110B2FE53E89EBB9923A0EF7113FDEEEBC57FDB21AA8F99D3757DB7C8A8E6458D3B628B357396E77CD3C31158B203BEDAF3AC56E11A94C3BA745CAE7847B6C7D5C6B1D6E68204147A9B98EC334560F94A484FC5335F8AA4716BF13E0153B9B0E7FF75384449563F935AF0173C5F8F1CBE20B1C91593C2F7AF07A83E48F31DA8F4F5959687A682823216342C6E1B36771AC42C9BF0E03F443D07D239F25EB916BC15A908796C698D296130A9BA4A925684416F9C759143","adyenOriginKey":"pub.v2.1114841580210853.aHR0cHM6Ly93d3cuY2hlc3MuY29t.g3hcnpsxbNsbEo3XJP_laQJwLDCkoYfA1YmHG6Kns8g","adyenLoadingContext":"https:\/\/checkoutshopper-live.adyen.com\/checkoutshopper\/","cohortsNoAdsFeature":true,"iterableMuteApiCallsFeature":true};
    //]]>
    
    context.version = '20200324075533';
    context.branch = 'master';
    context.commit = '8d31df83f0da7137d8f82da18184e385876094c8';
    context.requestId = 'f7d3e119a95b150cd3b4b9bd32b30ece';
    context.server = 'watson.chess.com';
    context.locale = 'en';
    context.environment = 'prod';
    context.cookies = {
      app: '',
      PHPSESSID: '',
      CHESSCOM_REMEMBERME: 'false'
    };
    context.ip = '82.209.210.90';
  </script>

  <div id="cdm-zone-end"></div>

  


<script defer="" src="/bundles/app/js/client/es6-translations/es6-translation.en_US.0f95d4a8.js"></script>

<script defer="" src="/bundles/app/js/vendor.client.ee30d9f7.js">
</script>

<script src="/bundles/app/js/amplitude.dll.339c7e62.js"></script>

    


<script src="/bundles/app/js/core.dll.bf86e61d.js"></script>

<script defer="" src="/bundles/app/js/navigation.client.4e3707dc.js">
</script>

    <script src="/bundles/app/js/vue.dll.1963acfe.js"></script>

      <script defer="" src="/bundles/app/js/base.client.bd9c6f6a.js">
    </script>
  

      
      
      <script defer="" src="/bundles/app/js/language-banner-loader.client.9cf23ecd.js">
    </script>
  
  

        
  


<script defer="" language="javascript" src="/bundles/app/js/roles-config.client.8871b84a.js"></script>

        <script src="https://browser.sentry-cdn.com/5.11.1/bundle.min.js" crossorigin="anonymous"></script>

    
    <script>
      window.chesscom = window.chesscom || {};
      window.chesscom.sentry = {
        appCookie: '',
        incrementCallback: 'https://www.chess.com/metrics/fe_sentry',
        key: '',
      }
    </script>

    <script src="https://betacssjs.chesscomfiles.com/bundles/app/js/sentry.client.f6f5a9f4.js"></script>
  
  
        
      
      <script defer="" src="/bundles/app/js/index.client.f874eee6.js">
    </script>
  
  

    
  
      <div id="adblocker-check"></div>
  
        <div id="board-popover"></div>
    <div id="challenge-popover"></div>
    <div id="confirm-popover"></div>
    <div id="confirm-popover-inline"></div>
    <div id="cookie-banner"></div>
    <div id="form-datepicker"></div>
    <div id="language-picker-modal"></div>
    <div id="message-popover"></div>
    <div id="modal-video"></div>
    <div id="trophy-popover"></div>
    <div id="user-popover"></div>
        

<div class="svelte-tooltip" style="transform: translate(-100%, -100%);"></div><script src="/bundles/app/js/adblocker-check.client.b202a4b5.js" defer=""></script></body>




</html>