package com.example.jobscraping.service;

import com.example.jobscraping.entity.JobPosting;
import com.example.jobscraping.repository.JobPostingRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JobScrapingService {

    private final JobPostingRepository jobPostingRepository;
    // 생성자 주입은 객체가 생성될 때 의존성을 주입하므로 필수적인 의존성을 강제할 수 있다.
    // 또한 불변성을 유지하면서도 테스트와 유지보수가 용이하다.

    public JobScrapingService(JobPostingRepository jobPostingRepository) {
        this.jobPostingRepository = jobPostingRepository;
        // Spring이 JobScrapingService를 생성할 때, JobPostingRepository 빈을 자동으로 주입하여,
        // this.jobPostingRepository에 할당해준다. 이를 통해 JobScrapingService는 JobPostingRepository에 접근하여
        // 데이터베이스 작업을 수행할 수 있습니다.
    }

    // 웹 스크래핑하는 메소드
    public void scrapJobTitles() throws IOException {
        // url 페이지에서 크롤링
        // 스크래핑할 페이지를 먼저 지정한다.
        String url = "https://www.work24.go.kr/wk/a/b/1200/retriveDtlEmpSrchList.do?basicSetupYn=&careerTo=&keywordJobCd=&occupation=133300&seqNo=&cloDateEndtParam=&payGbn=&templateInfo=&rot2WorkYn=&shsyWorkSecd=&srcKeywordParam=&resultCnt=10&keywordJobCont=&cert=&moreButtonYn=&minPay=&codeDepth2Info=11000&currentPageNo=1&eventNo=&mode=&major=&resrDutyExcYn=&eodwYn=&sortField=DATE&staArea=&sortOrderBy=DESC&keyword=&termSearchGbn=&carrEssYns=&benefitSrchAndOr=O&occupationParam=133300&disableEmpHopeGbn=&actServExcYn=&keywordStaAreaNm=&maxPay=&emailApplyYn=&codeDepth1Info=11000&keywordEtcYn=&regDateStdtParam=&publDutyExcYn=&keywordJobCdSeqNo=&viewType=&exJobsCd=&templateDepthNmInfo=&region=&employGbn=&empTpGbcd=1&computerPreferential=&infaYn=&cloDateStdtParam=&siteClcd=all&searchMode=Y&birthFromYY=&indArea=&careerTypes=N&subEmpHopeYn=&tlmgYn=&academicGbn=&templateDepthNoInfo=&foriegn=&entryRoute=&mealOfferClcd=&basicSetupYnChk=&station=&holidayGbn=&srcKeyword=&academicGbnoEdu=noEdu&enterPriseGbn=all&cloTermSearchGbn=&birthToYY=&keywordWantedTitle=&stationNm=&benefitGbn=&notSrcKeywordParam=&keywordFlag=&notSrcKeyword=&essCertChk=&depth2SelCode=&keywordBusiNm=&preferentialGbn=&rot3WorkYn=&regDateEndtParam=&pfMatterPreferential=&pageIndex=1&termContractMmcnt=&careerFrom=&laborHrShortYn=#scrollLoc";
        Document document = Jsoup.connect(url).get();
        // 페이지에서 스크래핑할 특정 부분을 지정한다
//        Elements parsingDivs = document.getElementsByAttributeValue("class","box_table type_pd24");
//        Element tableEle = parsingDivs.get(0);
        //Element tbody = tableEle.children().get(1);
//        System.out.println(tableEle);

        // 구인구직의 제목과 링크를 추출
        Elements jobElements = document.select("a.b1_sb.txt_ellipsis2.underline_hover.hoverUnderLine.cl-blue.fs-18");

        for (Element jobElement : jobElements) {
            String title = jobElement.text(); // 공고 제목
            String link = jobElement.attr("href"); // 공고 링크
            System.out.println("Job Title: " + title);
            System.out.println("Job Link: " + link);


        }


        // 크로링한 데이터 DB에 저장부분 만들어야함

    }

}
