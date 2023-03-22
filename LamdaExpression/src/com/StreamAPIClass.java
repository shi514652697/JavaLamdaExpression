package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPIClass {
	
	
private NumberListGroup[] numberListGroup;

private List<String> getCinList()
{
	return Arrays.stream(numberListGroup).map(NumberListGroup:: getCin).collect(Collectors.toList());
}

private List<Integer> getIds()
{
	return Arrays.stream(numberListGroup).map(NumberListGroup::getId).collect(Collectors.toList());
}


public List<ApplicantDTO> checkCin(List<ApplicantDTO> applicantList)
{
	int count = (int) applicantList.stream().filter(e-> e.getCin() != null).count();
	List<String> cinList;
	if(count != 0)
	{
		 cinList = Arrays.asList("123","234");
       AtomicInteger index = new AtomicInteger(0);
      applicantList.stream().filter(e-> e.getActionCode() != null).forEach(e->e.setCin(cinList.get(index.getAndIncrement())));
	}
	return applicantList;
}

private EmailGroup[] getEmailGroup(ApplicantDTO applicant)
{
	EmailGroup[] emailGroup = applicant.getEmail().stream().map(this::getEmailGroup).toArray(EmailGroup[]::new);
	
	return emailGroup;
}

private EmailGroup[] getEmailGroup2(ApplicantDTO applicant)
{
	return IntStream.range(0, applicant.getEmail().size()).mapToObj(e-> getEmailGroup(applicant.getEmail().get(e))).toArray(EmailGroup[]:: new);
}

private List<GreDocument> getGreDocument()
{
	Set<GreDocument> greDocument = new HashSet<>();
	
	return greDocument.stream().filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
}

private Document[] getDocument(List<Document> document)
{
	return document.stream().toArray(e-> new Document[e]);
}


public ApplicantDTO getApplicant(List<ApplicantDTO> applicantList)
{
	return applicantList.stream().filter(e-> e.getActionCode() != null).findAny().orElse(null);
}


private EmailGroup getEmailGroup(Email email)
{
	return new EmailGroup();
}




}
