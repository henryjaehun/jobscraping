package com.example.jobscraping.service;

import com.example.jobscraping.repository.JobPostingRepository;
import org.springframework.stereotype.Service;

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
    public void scrapJobTitles() {
        // url 페이지에서 크롤링


        // 크로링한 데이터 DB에 저장

    }
}
