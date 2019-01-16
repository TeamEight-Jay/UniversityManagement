package com.TeamEight.UniversityManagement.services.impl;

import com.TeamEight.UniversityManagement.entity.Professor;
import com.TeamEight.UniversityManagement.entity.Registration;
import com.TeamEight.UniversityManagement.repository.ProfessorRepository;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	final double AVERAGE_SCORE_WEIGHTAGE=0.8;
	final double STUDENT_COUNT_WEIGHTAGE=1-AVERAGE_SCORE_WEIGHTAGE;
	final double DEGRADE_FACTOR=0.98;
	@Autowired
	ProfessorRepository professorRepository;
	@Override
	public Professor add(Professor professor) {
		Professor professorAdded = professorRepository.save(professor);
		return professorAdded;
	}

	@Override
	public Professor select(String professorId) {
		return professorRepository.findOne(professorId);
	}

	@Override
	public double rating(String professorId) {
		Professor professor=this.select(professorId);

		HashMap<String,Double> averageScoreMap=new HashMap<String,Double>();
		HashMap<String,Integer> studentCountMap=new HashMap<String,Integer>();

		if(professor.getRegistrationList().size()==0) return 0;

		for(Registration registration:professor.getRegistrationList())
		{
			String key=registration.getSubjectId().getSubjectId();

			double totalScoreValue=averageScoreMap.getOrDefault(key,0.0);
			totalScoreValue+=((double)registration.getScore()/(double)registration.getSubjectId().getMaxScore());

			averageScoreMap.put(key,totalScoreValue);

			int studentCountValue=studentCountMap.getOrDefault(key,0);
			studentCountValue+=1;

			studentCountMap.put(key,studentCountValue);

		}

		TreeSet<Double> sortedScore=new TreeSet<Double>(Comparator.reverseOrder());

		for(String subject:averageScoreMap.keySet())
		{
			int studentCount=studentCountMap.get(subject);
			double averageScore=(averageScoreMap.get(subject)/(double)studentCount);
			double weightedSum=(AVERAGE_SCORE_WEIGHTAGE*averageScore)+(STUDENT_COUNT_WEIGHTAGE*studentCount);
			sortedScore.add(weightedSum);
		}

		double currentDegradeFactor=DEGRADE_FACTOR;
		double finalScore=0;
		for(double score:sortedScore)
		{
			finalScore+=(currentDegradeFactor*score);
			currentDegradeFactor*=currentDegradeFactor;
		}

		finalScore=finalScore/(double)sortedScore.size();

		return finalScore;
	}
}
